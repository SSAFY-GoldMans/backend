package com.goldmen.home.map.district.service;

import com.goldmen.home.map.district.domain.District;
import com.goldmen.home.map.district.domain.DistrictRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class DistrictService {
    private final DistrictRepository districtRepository;

    public District findDistrict(District district){
        return districtRepository.findByCode(district.getCode()).orElseThrow();
    }

    @Transactional
    public District saveDistrict(District district){
        return districtRepository.findByCode(district.getCode()).orElseGet(() -> districtRepository.save(district));
    }
}
