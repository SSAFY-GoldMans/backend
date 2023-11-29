package com.goldmen.home.map.district.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DistrictRepository extends JpaRepository<District, Integer> {
    Optional<District> findByCode(String code);

    Optional<District> findByName(String name);
}
