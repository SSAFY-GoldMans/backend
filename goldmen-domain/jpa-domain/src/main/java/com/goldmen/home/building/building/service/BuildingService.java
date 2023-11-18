package com.goldmen.home.building.building.service;

import com.goldmen.home.building.building.data.cond.FindBuildingOptionCond;
import com.goldmen.home.building.building.domain.Building;
import com.goldmen.home.building.building.domain.BuildingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class BuildingService {
    private final BuildingRepository buildingRepository;

    @Transactional
    public Building save(Building building){
        return buildingRepository.findFirstByOption(FindBuildingOptionCond.of(building))
                .orElseGet(()->buildingRepository.save(building));
    }

    public Building findById(Building building){
        return buildingRepository.findById(building.getId()).orElseThrow();
    }
}
