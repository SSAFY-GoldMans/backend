package com.goldmen.home.building.jeonse.service;

import com.goldmen.home.building.Monthly.cond.FindAllCondition;
import com.goldmen.home.building.building.domain.Building;
import com.goldmen.home.building.jeonse.domain.Jeonse;
import com.goldmen.home.building.jeonse.domain.JeonseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class JeonseService {
    private final JeonseRepository jeonseRepository;

    @Transactional
    public Jeonse save(Jeonse jeonse) {
        return jeonseRepository.findByHouseInfo(jeonse.getHouseInfo())
                .orElseGet(() -> jeonseRepository.save(jeonse));
    }

    public Jeonse findById(Jeonse jeonse) {
        return jeonseRepository.findByIdJoinMap(jeonse.getId()).orElseThrow();
    }

    public List<Jeonse> findAllByBuilding(Building building, FindAllCondition condition) {
        return jeonseRepository.findAllByBuildingAndCond(building, condition);
    }

    public List<Jeonse> findAllByBuildingId(Building building) {
        return jeonseRepository.findAllByBuilding(building);
    }
}
