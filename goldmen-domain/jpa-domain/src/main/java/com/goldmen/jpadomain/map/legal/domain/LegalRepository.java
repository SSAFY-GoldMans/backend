package com.goldmen.jpadomain.map.legal.domain;

import com.goldmen.jpadomain.map.district.domain.District;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LegalRepository extends JpaRepository<Legal, Integer> {
    Optional<Legal> findByNameAndDistrict_Name(String legalName, String districtName);

    Optional<Legal> findByCodeAndDistrict(String Code, District district);

}
