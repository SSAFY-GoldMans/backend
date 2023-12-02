package com.goldmen.jpadomain.metro.duration.domain.query;

import com.goldmen.jpadomain.metro.duration.domain.Duration;

import java.util.List;

public interface DurationRepositoryCustom {
    List<Duration> findByStationByStationIdAndTime(int stationId, int time);
}
