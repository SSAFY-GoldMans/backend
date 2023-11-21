package com.goldmen.home.metro.service;

import com.goldmen.home.building.service.HouseService;
import com.goldmen.home.metro.dto.NearMetroRequest;
import com.goldmen.home.metro.dto.NearMetroResponse;
import com.goldmen.home.metro.duration.domain.Duration;
import com.goldmen.home.metro.duration.service.DurationService;
import com.goldmen.home.metro.station.domain.Station;
import com.goldmen.home.metro.station.service.StationServiceImpl;
import com.goldmen.home.type.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class NearService {
    private final DurationService durationService;
    private final HouseService houseService;
    private final StationServiceImpl stationService;

    public ApiResponse<List<NearMetroResponse>> getNearMetroList(NearMetroRequest request) {
        int standId = stationService.findFirstStationByName(request.name().substring(0, request.name().length() - 1)).getId();
        List<Duration> durationList = durationService.getNearDurationByTime(standId, request.time());
        List<NearMetroResponse> responseList = durationList.stream().map(duration -> {
            Station station = getDiffStation(duration, standId);
            String buildingTypeKorean;
            if (request.buildingType().equals("APT")) {
                buildingTypeKorean = "아파트";
            } else if (request.buildingType().equals("OFFICETEL")) {
                buildingTypeKorean = "오피스텔";
            } else {
                throw new NoSuchElementException("건물 타입 매칭 에러");
            }
            int middlePrice = 0;
            try {
                middlePrice = houseService.getBuildingMiddlePrice(station, buildingTypeKorean, request.priceType());
            } catch (NoSuchMethodException e) {
                System.out.println(request);
                throw new RuntimeException(e);
            }
            return new NearMetroResponse(station.getName() + "역", duration.getTime() + "분", station.getLegal().getDistrict().getName() + " " + station.getLegal().getName(), priceToStr(middlePrice, 10000));
        }).toList();
        return ApiResponse.valueOf(responseList);
    }

    //start와 end 중 다른 역의 아이디 추출
    Station getDiffStation(Duration duration, int stationId) {
        if (duration.getEndStation().getId() == stationId) {
            return duration.getStartStation();
        } else {
            return duration.getEndStation();
        }
    }

    String priceToStr(int price, int unit) {
        long unitPrice = (long) price * unit;
        if (unitPrice >= 1e8) {
            return new DecimalFormat("#,##0.##억원").format(unitPrice / 1e8);
        } else {
            return new DecimalFormat("#,##0.##만원").format(unitPrice / 1e4);
        }
    }
}
