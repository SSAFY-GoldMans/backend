package com.goldmen.home.metro.duration.service;

import com.goldmen.home.metro.duration.domain.Duration;

import java.util.List;

public interface DurationLoadService {

    List<Duration> findNearStationByStationIdAndTime(int stationId, int time);
}
