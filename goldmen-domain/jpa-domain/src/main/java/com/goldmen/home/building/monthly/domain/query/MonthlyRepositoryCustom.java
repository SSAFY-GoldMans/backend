package com.goldmen.home.building.monthly.domain.query;

import com.goldmen.home.building.monthly.cond.FindAllCondition;
import com.goldmen.home.building.monthly.domain.Monthly;

import java.util.List;
import java.util.Optional;

public interface MonthlyRepositoryCustom {
    List<Monthly> findAlByBuildingIdAndCond(int buildingId, FindAllCondition cond);

    Optional<Monthly> findByIdJoinMap(int id);
}
