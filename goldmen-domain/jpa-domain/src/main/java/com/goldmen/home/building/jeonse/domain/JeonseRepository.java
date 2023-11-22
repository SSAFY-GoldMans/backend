package com.goldmen.home.building.jeonse.domain;

import com.goldmen.home.building.Monthly.cond.FindAllCondition;
import com.goldmen.home.building.building.domain.Building;
import com.goldmen.home.building.global.domain.HouseInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface JeonseRepository extends JpaRepository<Jeonse, Integer> {
    Optional<Jeonse> findByHouseInfo(HouseInfo houseInfo);

    List<Jeonse> findAllByBuilding(Building building);

    @Query(value = "select j from Jeonse j join fetch j.building b join fetch b.legal l join fetch l.district d " +
            "where j.building = :#{#building} " +
            "and :#{#cond.price.min} <= j.price " +
            "and j.price<= :#{#cond.price.max} " +
            "and :#{#cond.area.min} <= j.houseInfo.area " +
            "and j.houseInfo.area <= :#{#cond.area.max} " +
            "order by j.price")
    List<Jeonse> findAllByBuildingAndCond(@Param("building") Building building, @Param("cond") FindAllCondition cond);
}
