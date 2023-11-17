package com.goldmen.home.station.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.goldmen.home.station.vo.StationInfo;
import com.goldmen.home.station.vo.StationInfoRaw;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
@Service
public class SeoulOpenDataStationClient {
    private final ObjectMapper objectMapper;

    /**
     * 역 정보를 가져오는 API
     * @param path 역 정보 파일의 경로
     * @return 역 정보 리스트 List<{@link StationInfo}>
     * @throws IOException
     */
    public List<StationInfo> getStationInformationFile(String path) throws IOException {
        ClassPathResource resource = new ClassPathResource(path);
        StationInfoRaw stationInfoRaw = objectMapper.readValue(resource.getInputStream(), StationInfoRaw.class);
        return stationInfoRaw.getStationInfoList();
    }
}
