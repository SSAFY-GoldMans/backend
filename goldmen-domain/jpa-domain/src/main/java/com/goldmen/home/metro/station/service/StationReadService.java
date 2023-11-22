package com.goldmen.home.metro.station.service;

import com.goldmen.home.metro.station.domain.Station;

public interface StationReadService {
    Station findByName(String name);
}
