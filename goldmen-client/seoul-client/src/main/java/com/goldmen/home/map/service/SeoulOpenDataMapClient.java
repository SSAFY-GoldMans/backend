package com.goldmen.home.map.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.goldmen.home.map.config.property.SeoulOpenDataMapProperties;
import com.goldmen.home.map.dto.response.SeoulOpenDataMapResponse;
import com.goldmen.home.map.vo.SeoulOpenDataMap;
import com.goldmen.home.station.config.property.StationProperties;
import com.goldmen.home.station.dto.response.StationInfoResponse;
import com.goldmen.home.station.vo.StationInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
@Service
public class SeoulOpenDataMapClient {
    private final ObjectMapper objectMapper;
    private final SeoulOpenDataMapProperties mapProperties;

    /**
     * 역 정보를 가져오는 API
     *
     * @return 역 정보 리스트 List<{@link StationInfo}>
     * @throws IOException
     */
    public List<SeoulOpenDataMap> getSeoulOpenDataMapList() throws IOException {
        ClassPathResource resource = new ClassPathResource(mapProperties.getMapPath());
        SeoulOpenDataMapResponse response = objectMapper.readValue(resource.getInputStream(), SeoulOpenDataMapResponse.class);
        return response.getSeoulOpenDataMapList();
    }
}
