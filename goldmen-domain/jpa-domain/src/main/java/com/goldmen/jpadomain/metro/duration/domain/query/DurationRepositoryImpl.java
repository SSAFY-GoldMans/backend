package com.goldmen.jpadomain.metro.duration.domain.query;

import com.goldmen.jpadomain.metro.duration.domain.Duration;
import com.goldmen.jpadomain.map.district.domain.QDistrict;
import com.goldmen.jpadomain.map.legal.domain.QLegal;
import com.goldmen.jpadomain.metro.duration.domain.QDuration;
import com.goldmen.jpadomain.metro.station.domain.QStation;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;

import java.util.List;

public class DurationRepositoryImpl implements DurationRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    public DurationRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public List<Duration> findByStationByStationIdAndTime(int stationId, int time) {
        return queryFactory.selectFrom(QDuration.duration)
                .from(QDuration.duration)
                .join(QDuration.duration.startStation, QStation.station).fetchJoin()
                .join(QStation.station.legal, QLegal.legal).fetchJoin()
                .join(QLegal.legal.district, QDistrict.district).fetchJoin()
                .where(QDuration.duration.time.loe(time))
                .where((QDuration.duration.endStation.id.eq(stationId)
                        .or(QDuration.duration.startStation.id.eq(stationId))))
                .orderBy(QDuration.duration.time.asc())
                .fetch();
    }
}
