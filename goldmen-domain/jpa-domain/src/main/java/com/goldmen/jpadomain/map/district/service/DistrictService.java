package com.goldmen.jpadomain.map.district.service;

import com.goldmen.jpadomain.map.district.domain.District;
import com.goldmen.jpadomain.map.district.domain.DistrictRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class DistrictService {
    private final DistrictRepository districtRepository;

    public District findDistrict(District district){
        return districtRepository.findByCode(district.getCode()).orElseThrow();
    }

    public District findDistrictByName(District district){
        return districtRepository.findByName(district.getName()).orElseThrow();
    }

    @Transactional
    public District saveDistrict(District district){
        return districtRepository.findByCode(district.getCode()).orElseGet(() -> districtRepository.save(district));
    }
}
