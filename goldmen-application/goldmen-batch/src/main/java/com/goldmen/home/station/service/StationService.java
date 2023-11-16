package com.goldmen.home.station.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.goldmen.home.station.dto.response.StationInfoResponse;
import com.goldmen.home.station.vo.StationInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
@Service
public class StationService {

    private final ObjectMapper objectMapper;

    public List<StationInfo> getStationInformationFile(String path) throws IOException {
        ClassPathResource resource = new ClassPathResource(path);
        StationInfoResponse stationInfoRaw = objectMapper.readValue(resource.getInputStream(), StationInfoResponse.class);
        return stationInfoRaw.getStationInfoList();
    }
}
