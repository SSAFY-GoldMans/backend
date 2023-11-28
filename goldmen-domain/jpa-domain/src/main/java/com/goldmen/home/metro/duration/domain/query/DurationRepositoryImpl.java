package com.goldmen.home.metro.duration.domain.query;

import com.goldmen.home.metro.duration.domain.Duration;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;

import java.util.List;

import static com.goldmen.home.map.district.domain.QDistrict.district;
import static com.goldmen.home.map.legal.domain.QLegal.legal;
import static com.goldmen.home.metro.duration.domain.QDuration.duration;
import static com.goldmen.home.metro.station.domain.QStation.station;

public class DurationRepositoryImpl implements DurationRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    public DurationRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public List<Duration> findByStationByStationIdAndTime(int stationId, int time) {
        return queryFactory.selectFrom(duration)
                .from(duration)
                .join(duration.startStation, station).fetchJoin()
                .join(station.legal, legal).fetchJoin()
                .join(legal.district, district).fetchJoin()
                .where(duration.time.loe(time))
                .where((duration.endStation.id.eq(stationId)
                        .or(duration.startStation.id.eq(stationId))))
                .orderBy(duration.time.asc())
                .fetch();
    }
}
