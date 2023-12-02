package com.goldmen.api.house.service;

import com.goldmen.api.house.dto.request.GetHouseRequest;
import com.goldmen.api.house.dto.request.SaleableDetailRequest;
import com.goldmen.api.house.dto.response.GetHousePositionResponse;
import com.goldmen.api.house.dto.response.GetHouseResponse;
import com.goldmen.api.house.dto.response.SaleableDetailResponse;
import com.goldmen.api.mapper.ApiMapper;
import com.goldmen.jpadomain.building.building.domain.Building;
import com.goldmen.jpadomain.building.building.domain.BuildingEnum;
import com.goldmen.jpadomain.building.building.service.BuildingService;
import com.goldmen.jpadomain.building.global.domain.PriceEnum;
import com.goldmen.jpadomain.building.global.domain.Saleable;
import com.goldmen.jpadomain.building.jeonse.domain.Jeonse;
import com.goldmen.jpadomain.building.jeonse.service.JeonseService;
import com.goldmen.jpadomain.building.monthly.domain.Monthly;
import com.goldmen.jpadomain.building.monthly.service.MonthlyService;
import com.goldmen.jpadomain.metro.station.domain.Station;
import com.goldmen.jpadomain.metro.station.service.StationFindService;
import com.goldmen.common.type.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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
        return buildingList.stream().flatMap(building ->
                monthlyService.findAllByBuildingId(building.getId(), apiMapper.toFindAllCondition(request))
                        .stream()).collect(Collectors.toList());
    }

    private List<Saleable> getJeonse(List<Building> buildingList, GetHouseRequest request) {
        return buildingList.stream().flatMap(building ->
                jeonseService.findAllByBuilding(building.getId(), apiMapper.toFindAllCondition(request))
                        .stream()).collect(Collectors.toList());
    }

    public List<Building> getBuildingList(Station station, String buildingType) {
        return buildingService.findALlByStation(station).stream()
                .filter(building -> building.getType().equals(buildingType)).toList();
    }

    public List<? extends Saleable> getSaleableList(List<Building> buildingList, PriceEnum priceEnum) {
        if (Objects.requireNonNull(priceEnum) == PriceEnum.JEONSE) {
            return buildingList.stream().map(jeonseService::findAllByBuildingId)
                    .flatMap(List::stream).toList();
        } else if (priceEnum == PriceEnum.MONTHLY) {
            return buildingList.stream().map(monthlyService::findAllByBuildingId)
                    .flatMap(List::stream).toList();
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
        } else if (saleableList.get(0) instanceof Jeonse) {
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
