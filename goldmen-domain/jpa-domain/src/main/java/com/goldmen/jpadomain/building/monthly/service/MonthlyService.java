package com.goldmen.jpadomain.building.monthly.service;

import com.goldmen.jpadomain.building.building.domain.Building;
import com.goldmen.jpadomain.building.monthly.cond.FindAllCondition;
import com.goldmen.jpadomain.building.monthly.domain.Monthly;
import com.goldmen.jpadomain.building.monthly.domain.MonthlyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class MonthlyService {
    private final MonthlyRepository monthlyRepository;

    @Transactional
    public Monthly save(Monthly monthly) {
        return monthlyRepository.findByHouseInfo(monthly.getHouseInfo())
                .orElseGet(() -> monthlyRepository.save(monthly));
    }

    public Monthly findById(int id) {
        return monthlyRepository.findByIdJoinMap(id).orElseThrow();
    }

    public List<Monthly> findAllByBuildingId(int buildingId, FindAllCondition condition) {
        return monthlyRepository.findAlByBuildingIdAndCond(buildingId, condition);
    }

    public List<Monthly> findAllByBuildingId(Building building) {
        return monthlyRepository.findAllByBuilding(building);
    }
}
