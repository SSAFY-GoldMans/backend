package com.goldmen.home.building.jeonse.domain.query;

import com.goldmen.home.building.Monthly.cond.FindAllCondition;
import com.goldmen.home.building.jeonse.domain.Jeonse;

import java.util.List;
import java.util.Optional;

public interface JeonseRepositoryCustom {

    List<Jeonse> findAllByBuildingIdAndCond(int buildingId, FindAllCondition cond);

    Optional<Jeonse> findByIdJoinMap(int id);
}
