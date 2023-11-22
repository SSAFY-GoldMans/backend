package com.goldmen.home.metro.station.service;

import com.goldmen.home.metro.station.domain.Station;
import com.goldmen.home.metro.station.domain.StationRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class StationServiceImpl implements StationModifyService, StationReadService{
    private final StationRepository stationRepository;

    @Override
    @Transactional
    public Station save(Station station) {
        if(stationRepository.existsByNameAndLine(station.getName(), station.getLine())) {
            throw new RuntimeException("지하철 데이터 중복");
        }
        return stationRepository.save(station);
    }

    @Override
    public Station findByName(String name) {
        return stationRepository.findByName(name).orElseThrow();
    }
}
