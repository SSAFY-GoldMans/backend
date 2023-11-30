package com.goldmen.home.building.monthly.domain.query;

import com.goldmen.home.building.monthly.cond.Area;
import com.goldmen.home.building.monthly.cond.FindAllCondition;
import com.goldmen.home.building.monthly.cond.Price;
import com.goldmen.home.building.monthly.cond.Rent;
import com.goldmen.home.building.monthly.domain.Monthly;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.Optional;

import static com.goldmen.home.building.building.domain.QBuilding.building;
import static com.goldmen.home.building.monthly.domain.QMonthly.monthly;
import static com.goldmen.home.map.district.domain.QDistrict.district;
import static com.goldmen.home.map.legal.domain.QLegal.legal;

public class MonthlyRepositoryImpl implements MonthlyRepositoryCustom {
    private final JPAQueryFactory queryFactory;

    public MonthlyRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }


    @Override
    public List<Monthly> findAlByBuildingIdAndCond(int buildingId, FindAllCondition cond) {
        Area area = cond.getArea();
        Rent rent = cond.getRent();
        Price price = cond.getPrice();
        return queryFactory.selectFrom(monthly)
                .join(monthly.building, building).fetchJoin()
                .join(building.legal, legal).fetchJoin()
                .join(legal.district, district).fetchJoin()
                .where(building.id.eq(buildingId))
                .where(monthly.price.between(price.getMin(), price.getMax())
                        .and(monthly.houseInfo.area.between(area.getMin(), area.getMax()))
                        .and(monthly.rent.between(rent.getMin(), rent.getMax())))
                .orderBy(monthly.rent.asc())
                .fetch();
    }

    @Override
    public Optional<Monthly> findByIdJoinMap(int id) {
        Monthly findMonthly = queryFactory.selectFrom(monthly)
                .join(monthly.building, building).fetchJoin()
                .join(building.legal, legal).fetchJoin()
                .join(legal.district, district).fetchJoin()
                .where(monthly.id.eq(id))
                .fetchOne();
        return Optional.ofNullable(findMonthly);
    }
}
