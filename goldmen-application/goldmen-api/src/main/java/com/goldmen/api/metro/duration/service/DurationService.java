package com.goldmen.api.metro.duration.service;

import com.goldmen.jpadomain.metro.duration.domain.Duration;
import com.goldmen.jpadomain.metro.duration.service.DurationServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class DurationService {
    private final DurationServiceImpl durationServiceImpl;

    public List<Duration> getNearDurationByTime(int stationId, int time) {
        return durationServiceImpl.findNearStationByStationIdAndTime(stationId, time);
    }
}
