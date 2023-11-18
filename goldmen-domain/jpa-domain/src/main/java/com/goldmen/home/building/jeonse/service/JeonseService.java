package com.goldmen.home.building.jeonse.service;

import com.goldmen.home.building.Monthly.domain.Monthly;
import com.goldmen.home.building.Monthly.domain.MonthlyRepository;
import com.goldmen.home.building.jeonse.domain.Jeonse;
import com.goldmen.home.building.jeonse.domain.JeonseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class JeonseService {
    private final JeonseRepository jeonseRepository;

    @Transactional
    public Jeonse save(Jeonse jeonse) {
        return jeonseRepository.findByHouseInfo(jeonse.getHouseInfo())
                .orElse(jeonseRepository.save(jeonse));
    }

    public Jeonse findById(Jeonse jeonse) {
        return jeonseRepository.findById(jeonse.getId()).orElseThrow();
    }
}
