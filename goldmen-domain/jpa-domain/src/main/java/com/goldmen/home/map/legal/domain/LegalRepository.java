package com.goldmen.home.map.legal.domain;

import com.goldmen.home.map.district.domain.District;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LegalRepository extends JpaRepository<Legal, Integer> {
    Optional<Legal> findByCodeAndDistrict(String Code,District district);
}
