package com.goldmen.home.map.legal.service;

import com.goldmen.home.map.district.domain.District;
import com.goldmen.home.map.district.domain.DistrictRepository;
import com.goldmen.home.map.legal.domain.Legal;
import com.goldmen.home.map.legal.domain.LegalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class LegalService {
    private final LegalRepository legalRepository;

    public Legal getLegal(Legal legal) {
        return legalRepository.findByCode(legal.getCode())
                .orElse(saveLegal(legal));
    }

    public Legal saveLegal(Legal legal) {
        return legalRepository.save(legal);
    }
}
