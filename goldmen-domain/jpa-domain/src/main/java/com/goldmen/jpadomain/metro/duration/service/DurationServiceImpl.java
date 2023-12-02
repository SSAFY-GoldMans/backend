package com.goldmen.jpadomain.metro.duration.service;

import com.goldmen.jpadomain.metro.duration.domain.Duration;
import com.goldmen.jpadomain.metro.duration.domain.DurationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DurationServiceImpl implements DurationLoadService {
    private final DurationRepository durationRepository;

    @Override
    public List<Duration> findNearStationByStationIdAndTime(int stationId, int time) {
        return durationRepository.findByStationByStationIdAndTime(stationId, time);
    }
}
