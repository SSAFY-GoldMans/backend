package com.goldmen.home.building.Monthly.domain;

import com.goldmen.home.building.building.domain.Building;
import com.goldmen.home.building.global.domain.HouseInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MonthlyRepository extends JpaRepository<Monthly, Integer> {
    Optional<Monthly> findByHouseInfo(HouseInfo houseInfo);

    List<Monthly> findAllByBuilding(Building building);
}
