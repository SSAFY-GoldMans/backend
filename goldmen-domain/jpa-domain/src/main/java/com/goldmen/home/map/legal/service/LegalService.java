package com.goldmen.home.map.legal.service;

import com.goldmen.home.map.legal.domain.Legal;
import com.goldmen.home.map.legal.domain.LegalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class LegalService {
    private final LegalRepository legalRepository;

    public Legal findLegal(Legal legal) {
        return legalRepository.findByCodeAndDistrict(legal.getCode(), legal.getDistrict())
                .orElseThrow();
    }

    public Legal findByNameAndDistrictName(String legalName, String districtName) {
        return legalRepository.findByNameAndDistrict_Name(legalName, districtName).orElseThrow();
    }

    public Legal findByCodeAndDistrict(Legal legal) {
        return legalRepository.findByCodeAndDistrict(legal.getCode(), legal.getDistrict())
                .orElseThrow();
    }

    @Transactional
    public Legal saveLegal(Legal legal) {
        return legalRepository.findByCodeAndDistrict(legal.getCode(), legal.getDistrict())
                .orElseGet(() -> legalRepository.save(legal));
    }
}
