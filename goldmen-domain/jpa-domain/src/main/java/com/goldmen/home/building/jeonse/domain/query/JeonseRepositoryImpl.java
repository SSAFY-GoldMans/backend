package com.goldmen.home.building.jeonse.domain.query;

import com.goldmen.home.building.jeonse.domain.Jeonse;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;

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
