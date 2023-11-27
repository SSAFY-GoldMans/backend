package com.goldmen.home.metro.duration.domain.query;

import com.goldmen.home.metro.duration.domain.Duration;

import java.util.List;

public interface DurationRepositoryCustom {
    List<Duration> findByStationByStationIdAndTime(int stationId, int time);
}
