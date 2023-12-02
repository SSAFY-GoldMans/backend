package com.goldmen.jpadomain.building.jeonse.domain.query;

import com.goldmen.jpadomain.building.monthly.cond.FindAllCondition;
import com.goldmen.jpadomain.building.jeonse.domain.Jeonse;

import java.util.List;
import java.util.Optional;

public interface JeonseRepositoryCustom {

    List<Jeonse> findAllByBuildingIdAndCond(int buildingId, FindAllCondition cond);

    Optional<Jeonse> findByIdJoinMap(int id);
}
