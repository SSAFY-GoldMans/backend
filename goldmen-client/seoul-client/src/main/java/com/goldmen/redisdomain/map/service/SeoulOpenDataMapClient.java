package com.goldmen.redisdomain.map.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.goldmen.redisdomain.map.config.property.SeoulOpenDataMapProperties;
import com.goldmen.redisdomain.map.dto.response.SeoulOpenDataMapResponse;
import com.goldmen.redisdomain.map.vo.SeoulOpenDataMap;
import com.goldmen.redisdomain.station.vo.StationInfo;
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
