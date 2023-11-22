package com.goldmen.home.house.service;

import com.goldmen.home.building.Monthly.domain.Monthly;
import com.goldmen.home.building.Monthly.service.MonthlyService;
import com.goldmen.home.building.building.domain.Building;
import com.goldmen.home.building.building.service.BuildingService;
import com.goldmen.home.building.global.domain.Saleable;
import com.goldmen.home.building.jeonse.domain.Jeonse;
import com.goldmen.home.building.jeonse.service.JeonseService;
import com.goldmen.home.house.dto.request.GetHouseRequest;
import com.goldmen.home.house.dto.response.GetHousePositionResponse;
import com.goldmen.home.house.dto.request.SaleableDetailRequest;
import com.goldmen.home.house.dto.response.GetHouseResponse;
import com.goldmen.home.mapper.ApiMapper;
import com.goldmen.home.metro.station.domain.Station;
import com.goldmen.home.metro.station.service.StationFindService;
import com.goldmen.home.type.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class HouseService {
    private final BuildingService buildingService;
    private final StationFindService stationReadService;
    private final JeonseService jeonseService;
    private final MonthlyService monthlyService;
    private final ApiMapper apiMapper;

    public ApiResponse<GetHouseResponse> getHouse(GetHouseRequest request) {
        Station station = stationReadService.findByName(request.getStationName());
        List<Building> buildingList = buildingService.findALlByStation(station, request.getBuildingType());
        if (request.getRentType().equals("JEONSE")) {
            List<Saleable> jeonseList = getJeonse(buildingList, request);
            return ApiResponse.valueOf(GetHouseResponse.from(jeonseList));
        } else {
            List<Saleable> monthlyList = getMonthly(buildingList, request);
            return ApiResponse.valueOf(GetHouseResponse.from(monthlyList));
        }
    }

    public ApiResponse<GetHousePositionResponse> getHousePosition(GetHouseRequest request) {
        Station station = stationReadService.findByName(request.getStationName());
        List<Building> buildingList = buildingService.findALlByStation(station, request.getBuildingType());
        if (request.getRentType().equals("JEONSE")) {
            List<Saleable> jeonseList = getJeonse(buildingList, request);
            return ApiResponse.valueOf(GetHousePositionResponse.from(jeonseList));
        } else {
            List<Saleable> monthlyList = getMonthly(buildingList, request);
            return ApiResponse.valueOf(GetHousePositionResponse.from(monthlyList));
        }
    }

    private List<Saleable> getMonthly(List<Building> buildingList, GetHouseRequest request) {
        List<Saleable> monthlyList = new ArrayList<>();
        for (Building building : buildingList) {
            monthlyList.addAll(monthlyService.findAllByBuilding(building, apiMapper.toFindAllCondition(request)));
        }
        return monthlyList;
    }

    private List<Saleable> getJeonse(List<Building> buildingList, GetHouseRequest request) {
        List<Saleable> jeonseList = new ArrayList<>();
        for (Building building : buildingList) {
            jeonseList.addAll(jeonseService.findAllByBuilding(building, apiMapper.toFindAllCondition(request)));
        }
        return jeonseList;
    }

    private List<Building> getBuildingList(Station station) {
        return buildingService.findALlByStation(station);
    }

    public int getBuildingMiddlePrice(Station station, String buildingType, String priceType) {
        List<Building> buildingList = getBuildingList(station).stream()
                .filter(building -> building.getType().equals(buildingType)).toList();
        if (buildingList.isEmpty()) {
            return 0;
        } else if (priceType.equals("JEONSE")) {
            List<Jeonse> jeonsesList = buildingList.stream()
                    .map(jeonseService::findAllByBuildingId)
                    .flatMap(List::stream).toList();
            return jeonsesList.get(jeonsesList.size() / 2).getPrice();
        } else {
            List<Monthly> monthlyList = buildingList.stream()
                    .map(monthlyService::findAllByBuildingId)
                    .flatMap(List::stream).toList();
            return monthlyList.get(monthlyList.size() / 2).getRent();
        }
    }

    public Saleable getSaleable(SaleableDetailRequest request) {
        Saleable saleable = null;
        switch (request.priceEnum()) {
            case JEONSE -> saleable = jeonseService.findById(Jeonse.builder().id(request.saleableId()).build());
            case MONTHLY -> saleable = monthlyService.findById(Monthly.builder().id(request.saleableId()).build());
        }
        return saleable;
    }
}
