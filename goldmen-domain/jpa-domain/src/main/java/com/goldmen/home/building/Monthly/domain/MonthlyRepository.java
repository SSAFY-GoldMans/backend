package com.goldmen.home.building.Monthly.domain;

import com.goldmen.home.building.Monthly.cond.FindAllCondition;
import com.goldmen.home.building.building.domain.Building;
import com.goldmen.home.building.global.domain.HouseInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface MonthlyRepository extends JpaRepository<Monthly, Integer> {
    Optional<Monthly> findByHouseInfo(HouseInfo houseInfo);

    List<Monthly> findAllByBuilding(Building building);

    @Query(value = "select m from Monthly m join fetch m.building b join fetch b.legal l join fetch l.district " +
            "where m.building = :#{#building} " +
            "and :#{#cond.price.min} <= m.price and m.price<= :#{#cond.price.max} " +
            "and :#{#cond.area.min} <= m.houseInfo.area and m.houseInfo.area <= :#{#cond.area.max} " +
            "and :#{#cond.price.min} <= m.price and m.price <= :#{#cond.price.max} order by m.price")
    List<Monthly> findAllByBuildingAndCond(@Param("building") Building building, @Param("cond") FindAllCondition cond);

    @Query(value = "select m from Monthly m " +
            "join fetch m.building " +
            "join fetch m.building.legal " +
            "join fetch m.building.legal.district " +
            "where m.id = :id")
    Optional<Monthly> findById(@Param("id") int id);
}
