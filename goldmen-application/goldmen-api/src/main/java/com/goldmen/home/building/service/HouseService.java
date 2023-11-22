package com.goldmen.home.building.service;

import com.goldmen.home.building.Monthly.domain.Monthly;
import com.goldmen.home.building.Monthly.service.MonthlyService;
import com.goldmen.home.building.building.domain.Building;
import com.goldmen.home.building.building.service.BuildingService;
import com.goldmen.home.building.jeonse.domain.Jeonse;
import com.goldmen.home.building.jeonse.service.JeonseService;
import com.goldmen.home.metro.station.domain.Station;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HouseService {
    private final BuildingService buildingService;
    private final JeonseService jeonseService;
    private final MonthlyService monthlyService;

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
}
