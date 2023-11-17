package com.goldmen.home.station.service;

import com.goldmen.home.station.vo.StationInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
@Service
public class StationService {
    private SeoulOpenDataStationClient stationClient;

    public List<StationInfo> getStationInformation(String path) throws IOException {
        return stationClient.getStationInformationFile(path);
    }
}