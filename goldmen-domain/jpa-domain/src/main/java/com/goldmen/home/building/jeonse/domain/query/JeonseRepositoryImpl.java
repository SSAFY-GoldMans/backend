package com.goldmen.home.building.jeonse.domain.query;

import com.goldmen.home.building.Monthly.cond.Area;
import com.goldmen.home.building.Monthly.cond.FindAllCondition;
import com.goldmen.home.building.Monthly.cond.Price;
import com.goldmen.home.building.jeonse.domain.Jeonse;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.Optional;

import static com.goldmen.home.building.building.domain.QBuilding.building;
import static com.goldmen.home.building.jeonse.domain.QJeonse.jeonse;
import static com.goldmen.home.map.district.domain.QDistrict.district;
import static com.goldmen.home.map.legal.domain.QLegal.legal;


public class JeonseRepositoryImpl implements JeonseRepositoryCustom {
    private final JPAQueryFactory queryFactory;

    public JeonseRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public List<Jeonse> findAllByBuildingIdAndCond(int buildingId, FindAllCondition cond) {
        Area area = cond.getArea();
        Price price = cond.getPrice();
        return queryFactory.selectFrom(jeonse)
                .join(jeonse.building, building).fetchJoin()
                .join(building.legal, legal).fetchJoin()
                .join(legal.district, district).fetchJoin()
                .where(building.id.eq(buildingId))
                .where(building.type.eq(cond.getBuildingType())
                        .and(jeonse.houseInfo.area.between(area.getMin(), area.getMax()))
                        .and(jeonse.price.between(price.getMin(), price.getMax())))
                .orderBy(jeonse.price.desc())
                .fetch();
    }

    @Override
    public Optional<Jeonse> findByIdJoinMap(int id) {
        Jeonse findJeonse = queryFactory.selectFrom(jeonse)
                .join(jeonse.building, building).fetchJoin()
                .join(building.legal, legal).fetchJoin()
                .join(legal.district, district).fetchJoin()
                .where(jeonse.id.eq(id))
                .fetchOne();
        return Optional.ofNullable(findJeonse);
    }
}
