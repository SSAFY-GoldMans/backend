package com.goldmen.home.building.jeonse.domain.query;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;


public class JeonseRepositoryImpl implements JeonseRepositoryCustom {
    private final JPAQueryFactory queryFactory;

    public JeonseRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }


}
