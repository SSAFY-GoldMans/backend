package com.goldmen.home.building.jeonse.domain.query;

import com.goldmen.home.building.jeonse.domain.Jeonse;

import java.util.Optional;

public interface JeonseRepositoryCustom {
    Optional<Jeonse> findByIdJoinMap(int id);
}
