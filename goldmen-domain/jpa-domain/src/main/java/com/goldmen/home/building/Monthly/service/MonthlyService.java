package com.goldmen.home.building.Monthly.service;

import com.goldmen.home.building.Monthly.cond.FindAllCondition;
import com.goldmen.home.building.Monthly.domain.Monthly;
import com.goldmen.home.building.Monthly.domain.MonthlyRepository;
import com.goldmen.home.building.building.domain.Building;
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

    public Monthly findById(Monthly monthly) {
        return monthlyRepository.findById(monthly.getId()).orElseThrow();
    }
    public List<Monthly> findAllByBuilding(Building building, FindAllCondition condition) {
        return monthlyRepository.findAllByBuildingAndCond(building, condition);
    }
    public List<Monthly> findAllByBuildingId(Building building) {
        return monthlyRepository.findAllByBuilding(building);
    }
}
