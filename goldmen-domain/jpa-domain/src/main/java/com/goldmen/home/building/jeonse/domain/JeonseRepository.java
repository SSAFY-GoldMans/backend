package com.goldmen.home.building.jeonse.domain;

import com.goldmen.home.building.global.domain.HouseInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JeonseRepository extends JpaRepository<Jeonse, Integer> {
    Optional<Jeonse> findByHouseInfo(HouseInfo houseInfo);
}
