package com.goldmen.home.station.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.goldmen.home.station.config.property.StationProperties;
import com.goldmen.home.station.vo.StationInfo;
import com.goldmen.home.station.dto.response.StationInfoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
@Service
public class SeoulOpenDataStationClient {
    private final ObjectMapper objectMapper;
    private final StationProperties stationProperties;

    /**
     * 역 정보를 가져오는 API
     *
     * @return 역 정보 리스트 List<{@link StationInfo}>
     * @throws IOException
     */
    public List<StationInfo> getStationInformationFile() throws IOException {
        ClassPathResource resource = new ClassPathResource(stationProperties.getStationPath());
        StationInfoResponse response = objectMapper.readValue(resource.getInputStream(), StationInfoResponse.class);
        return response.getStationInfoList();
    }
}
