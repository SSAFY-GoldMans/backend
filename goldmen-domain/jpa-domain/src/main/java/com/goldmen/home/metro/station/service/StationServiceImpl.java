package com.goldmen.home.metro.station.service;

import com.goldmen.home.metro.station.domain.Station;
import com.goldmen.home.metro.station.domain.StationRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class StationServiceImpl implements StationModifyService {
    private final StationRepository stationRepository;

    @Override
    @Transactional
    public Station save(Station station) {
        return stationRepository.save(station);
    }
}
