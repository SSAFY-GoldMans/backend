package com.goldmen.home.metro.duration.service;

import com.goldmen.home.metro.duration.domain.Duration;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class DurationService {
    private final DurationServiceImpl durationServiceImpl;

    public List<Integer> getNearStationByTime(int stationId, int time) {
        List<Duration> durationList = durationServiceImpl.findNearStationByStationIdAndTime(stationId, time);
        return durationList.stream().map(duration -> { //start와 end 중 다른 역의 아이디 추출
            if (duration.getEndStation().getId() == stationId) {
                return duration.getStartStation().getId();
            } else {
                return duration.getEndStation().getId();
            }
        }).toList();
    }
}
