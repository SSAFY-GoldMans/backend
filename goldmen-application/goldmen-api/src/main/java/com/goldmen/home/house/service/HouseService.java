package com.goldmen.home.house.service;

import com.goldmen.home.building.Monthly.domain.Monthly;
import com.goldmen.home.building.Monthly.service.MonthlyService;
import com.goldmen.home.building.building.domain.Building;
import com.goldmen.home.building.building.domain.BuildingEnum;
import com.goldmen.home.building.building.service.BuildingService;
import com.goldmen.home.building.global.domain.PriceEnum;
import com.goldmen.home.building.global.domain.Saleable;
import com.goldmen.home.building.jeonse.domain.Jeonse;
import com.goldmen.home.building.jeonse.service.JeonseService;
import com.goldmen.home.house.dto.request.GetHouseRequest;
import com.goldmen.home.house.dto.request.SaleableDetailRequest;
import com.goldmen.home.house.dto.response.GetHousePositionResponse;
import com.goldmen.home.house.dto.response.GetHouseResponse;
import com.goldmen.home.house.dto.response.SaleableDetailResponse;
import com.goldmen.home.mapper.ApiMapper;
import com.goldmen.home.metro.station.domain.Station;
import com.goldmen.home.metro.station.service.StationFindService;
import com.goldmen.home.type.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
@Service
public class HouseService {
    private final BuildingService buildingService;
    private final StationFindService stationReadService;
    private final JeonseService jeonseService;
    private final MonthlyService monthlyService;
    private final ApiMapper apiMapper;

    public ApiResponse<GetHouseResponse> getHouse(GetHouseRequest request) {
        Station station = stationReadService.findFirstStationByName(
                request.getStationName().substring(0, request.getStationName().length() - 1));
        List<Building> buildingList = buildingService.findALlByStation(station, request.getBuildingEnum().strKorean);
        if (request.getRentType().equals("JEONSE")) {
            List<Saleable> jeonseList = getJeonse(buildingList, request);
            return ApiResponse.valueOf(GetHouseResponse.from(jeonseList));
        } else {
            List<Saleable> monthlyList = getMonthly(buildingList, request);
            return ApiResponse.valueOf(GetHouseResponse.from(monthlyList));
        }
    }

    public ApiResponse<GetHousePositionResponse> getHousePosition(GetHouseRequest request) {
        Station station = stationReadService.findByName(request.getStationName().substring(0, request.getStationName().length() - 1));
        List<Building> buildingList = buildingService.findALlByStation(station, request.getBuildingEnum().strKorean);
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

    public List<Building> getBuildingList(Station station, String buildingType) {
        return buildingService.findALlByStation(station).stream()
                .filter(building -> building.getType().equals(buildingType)).toList();
    }

    public List<? extends Saleable> getSaleableList(List<Building> buildingList, PriceEnum priceEnum) {
        switch (priceEnum) {
            case JEONSE -> {
                return buildingList.stream().map(jeonseService::findAllByBuildingId)
                        .flatMap(List::stream).toList();
            }
            case MONTHLY -> {
                return buildingList.stream().map(monthlyService::findAllByBuildingId)
                        .flatMap(List::stream).toList();
            }
        }
        return List.of();
    }

    public List<? extends Saleable> getSaleableList(Station station, BuildingEnum buildingEnum, PriceEnum priceEnum) {
        List<Building> buildingList = getBuildingList(station, buildingEnum.strKorean);
        return getSaleableList(buildingList, priceEnum);
    }

    public int getMiddlePrice(List<? extends Saleable> saleableList) {
        if (saleableList.isEmpty()) {
            return 0;
        } else if (saleableList.get(0) instanceof Monthly) {
            return saleableList.get(saleableList.size() / 2).getPrice();
        } else {
            return ((Monthly) saleableList.get(saleableList.size() / 2)).getRent();
        }
    }

    public ApiResponse<SaleableDetailResponse> getSaleable(SaleableDetailRequest request) {
        Saleable saleable = null;
        if (Objects.requireNonNull(request.priceEnum()) == PriceEnum.JEONSE) {
            saleable = jeonseService.findById(Jeonse.builder().id(request.saleableId()).build());
        } else if (request.priceEnum() == PriceEnum.MONTHLY) {
            saleable = monthlyService.findById(Monthly.builder().id(request.saleableId()).build());
        }
        return ApiResponse.valueOf(SaleableDetailResponse.from(saleable));
    }
}
