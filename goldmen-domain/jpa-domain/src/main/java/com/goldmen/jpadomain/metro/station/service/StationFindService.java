package com.goldmen.jpadomain.metro.station.service;

import com.goldmen.jpadomain.metro.station.domain.Station;

public interface StationFindService {
    Station findFirstStationByName(String name);

    Station findByName(String name);
}
