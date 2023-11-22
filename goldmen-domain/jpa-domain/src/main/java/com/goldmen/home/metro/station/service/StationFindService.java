package com.goldmen.home.metro.station.service;

import com.goldmen.home.metro.station.domain.Station;

public interface StationFindService {
    Station findFirstStationByName(String name);
}
