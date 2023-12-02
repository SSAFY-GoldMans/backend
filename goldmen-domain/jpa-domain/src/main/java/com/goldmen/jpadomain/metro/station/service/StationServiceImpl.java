package com.goldmen.jpadomain.metro.station.service;

import com.goldmen.jpadomain.metro.station.domain.Station;
import com.goldmen.jpadomain.metro.station.domain.StationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class StationServiceImpl implements StationModifyService, StationFindService {
    private final StationRepository stationRepository;

    @Override
    @Transactional
    public Station save(Station station) {
        if (stationRepository.existsByNameAndLine(station.getName(), station.getLine())) {
            throw new RuntimeException("지하철 데이터 중복");
        }
        return stationRepository.save(station);
    }

    @Override
    public Station findByName(String name) {
        return stationRepository.findByName(name).orElseThrow();
    }

    @Override
    public Station findFirstStationByName(String name) {
        return stationRepository.findFirstByName(name).orElseThrow(() -> new NoSuchElementException("No value present " + name));
    }
}
