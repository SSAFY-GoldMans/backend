package com.goldmen.jpadomain.building.monthly.domain;

import com.goldmen.jpadomain.building.building.domain.Building;
import com.goldmen.jpadomain.building.global.domain.HouseInfo;
import com.goldmen.jpadomain.building.monthly.domain.query.MonthlyRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MonthlyRepository extends JpaRepository<Monthly, Integer>, MonthlyRepositoryCustom {
    Optional<Monthly> findByHouseInfo(HouseInfo houseInfo);

    List<Monthly> findAllByBuilding(Building building);
}
