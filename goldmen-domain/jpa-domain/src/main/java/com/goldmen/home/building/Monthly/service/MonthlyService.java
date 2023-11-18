package com.goldmen.home.building.Monthly.service;

import com.goldmen.home.building.Monthly.domain.Monthly;
import com.goldmen.home.building.Monthly.domain.MonthlyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class MonthlyService {
    private final MonthlyRepository monthlyRepository;

    @Transactional
    public Monthly save(Monthly monthly){
        return monthlyRepository.findByHouseInfo(monthly.getHouseInfo())
                .orElse(monthlyRepository.save(monthly));
    }

    public Monthly findById(Monthly monthly){
        return monthlyRepository.findById(monthly.getId()).orElseThrow();
    }
}
