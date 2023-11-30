package com.goldmen.home.building.building.service;

import com.goldmen.home.building.building.data.cond.FindBuildingOptionCond;
import com.goldmen.home.building.building.domain.Building;
import com.goldmen.home.building.building.domain.BuildingRepository;
import com.goldmen.home.metro.station.domain.Station;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class BuildingService {
    private final BuildingRepository buildingRepository;

    @Transactional
    public Building save(Building building){
        return buildingRepository.findFirstByOption(FindBuildingOptionCond.from(building))
                .orElseGet(()->buildingRepository.save(building));
    }

    public Building findById(Building building){
        return buildingRepository.findById(building.getId()).orElseThrow();
    }

    /**
     * 역 주변 건물 목록 조회, 800M 기준(걸어서 10분거리)
     * @param station {@link Station}
     * @return {@link Building}
     */
    public List<Building> findALlByStation(Station station){
        return buildingRepository.findAllByLocationAndDist(station.getLat(),station.getLng(),800);
    }

    public List<Building> findALlByStation(Station station,String buildingType){
        return buildingRepository.findAllByLocationAndDistAndBuildingType(station.getLat(),station.getLng(),800,buildingType);
    }
}
