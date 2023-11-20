package com.goldmen.home.metro.duration.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DurationRepository extends JpaRepository<Duration, Integer> {
    @Query("select d " +
            "from Duration d " +
            "where :time >= d.time " +
            "AND (d.endStation.id = :station_id OR d.startStation.id = :station_id)")
    List<Duration> findNearStationByStationIdAndTime(@Param("station_id") int stationId, @Param("time") int time);
}
