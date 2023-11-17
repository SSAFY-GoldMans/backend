package com.goldmen.home.map.district.service;

import com.goldmen.home.map.district.domain.District;
import com.goldmen.home.map.district.domain.DistrictRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class DistrictService {
    private final DistrictRepository districtRepository;

    public District getDistrict(District district){
        return districtRepository.findByCode(district.getCode())
                .orElse(saveDistrict(district));
    }

    public District saveDistrict(District district){
        return districtRepository.save(district);
    }
}
