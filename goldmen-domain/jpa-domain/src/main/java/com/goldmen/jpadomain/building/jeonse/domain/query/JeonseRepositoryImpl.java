package com.goldmen.jpadomain.building.jeonse.domain.query;

import com.goldmen.jpadomain.building.jeonse.domain.Jeonse;
import com.goldmen.jpadomain.building.monthly.cond.Area;
import com.goldmen.jpadomain.building.monthly.cond.FindAllCondition;
import com.goldmen.jpadomain.building.monthly.cond.Price;
import com.goldmen.jpadomain.building.building.domain.QBuilding;
import com.goldmen.jpadomain.building.jeonse.domain.QJeonse;
import com.goldmen.jpadomain.map.district.domain.QDistrict;
import com.goldmen.jpadomain.map.legal.domain.QLegal;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.Optional;


public class JeonseRepositoryImpl implements JeonseRepositoryCustom {
    private final JPAQueryFactory queryFactory;

    public JeonseRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public List<Jeonse> findAllByBuildingIdAndCond(int buildingId, FindAllCondition cond) {
        Area area = cond.getArea();
        Price price = cond.getPrice();
        return queryFactory.selectFrom(QJeonse.jeonse)
                .join(QJeonse.jeonse.building, QBuilding.building).fetchJoin()
                .join(QBuilding.building.legal, QLegal.legal).fetchJoin()
                .join(QLegal.legal.district, QDistrict.district).fetchJoin()
                .where(QBuilding.building.id.eq(buildingId))
                .where(QBuilding.building.type.eq(cond.getBuildingType())
                        .and(QJeonse.jeonse.houseInfo.area.between(area.getMin(), area.getMax()))
                        .and(QJeonse.jeonse.price.between(price.getMin(), price.getMax())))
                .orderBy(QJeonse.jeonse.price.desc())
                .fetch();
    }

    @Override
    public Optional<Jeonse> findByIdJoinMap(int id) {
        Jeonse findJeonse = queryFactory.selectFrom(QJeonse.jeonse)
                .join(QJeonse.jeonse.building, QBuilding.building).fetchJoin()
                .join(QBuilding.building.legal, QLegal.legal).fetchJoin()
                .join(QLegal.legal.district, QDistrict.district).fetchJoin()
                .where(QJeonse.jeonse.id.eq(id))
                .fetchOne();
        return Optional.ofNullable(findJeonse);
    }
}
