package com.goldmen.jpadomain.metro.duration.service;

import com.goldmen.jpadomain.metro.duration.domain.Duration;

import java.util.List;

public interface DurationLoadService {

    List<Duration> findNearStationByStationIdAndTime(int stationId, int time);
}
