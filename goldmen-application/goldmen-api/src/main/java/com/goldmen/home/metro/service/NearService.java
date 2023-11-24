package com.goldmen.home.metro.service;

import com.goldmen.home.building.global.domain.Saleable;
import com.goldmen.home.house.service.HouseService;
import com.goldmen.home.metro.dto.NearMetroRequest;
import com.goldmen.home.metro.dto.NearMetroResponse;
import com.goldmen.home.metro.duration.domain.Duration;
import com.goldmen.home.metro.duration.service.DurationService;
import com.goldmen.home.metro.station.domain.Station;
import com.goldmen.home.metro.station.service.StationServiceImpl;
import com.goldmen.home.type.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import static com.goldmen.home.global.Mapper.stationToNearMetroResponse;

@Service
@RequiredArgsConstructor
public class NearService {
    private final DurationService durationService;
    private final HouseService houseService;
    private final StationServiceImpl stationService;

    @Cacheable(cacheNames = "station_info")
    public ApiResponse<List<NearMetroResponse>> getNearMetroList(NearMetroRequest request) {
        int standId = stationService.findFirstStationByName(request.name().substring(0, request.name().length() - 1)).getId();
        List<Duration> durationList = durationService.getNearDurationByTime(standId, request.time());
        LinkedHashMap<String, NearMetroResponse> map = new LinkedHashMap<>();
        durationList.forEach(duration -> {
            Station station = getDiffStation(duration, standId);
            List<? extends Saleable> saleableList = houseService.getSaleableList(station, request.buildingEnum(), request.priceEnum());
            NearMetroResponse response = stationToNearMetroResponse(station, houseService.getMiddlePrice(saleableList), duration.getTime(), saleableList.size(), new ArrayList<>(List.of(station.getLine().getId())));
            NearMetroResponse value = map.get(response.stationName());
            if (value != null) {
                value.lines().addAll(response.lines());
            } else {
                map.put(response.stationName(), response);
            }
        });
        return ApiResponse.valueOf(map.values().stream().toList());
    }

    private List<Duration> getDistinctDurationList(List<Duration> durationList, int standId) {
        LinkedHashMap<String, Duration> map = new LinkedHashMap<>();
        durationList.forEach((duration -> {
            String name = getDiffStation(duration, standId).getName();
            map.putIfAbsent(name, duration);
        }));
        return map.values().stream().toList();
    }

    //start와 end 중 다른 역의 아이디 추출
    Station getDiffStation(Duration duration, int stationId) {
        if (duration.getEndStation().getId() == stationId) {
            return duration.getStartStation();
        } else {
            return duration.getEndStation();
        }
    }
}
