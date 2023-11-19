package com.goldmen.home.map.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.goldmen.home.dto.request.KaKaoKeywordAPIRequest;
import com.goldmen.home.map.district.domain.District;
import com.goldmen.home.map.district.service.DistrictService;
import com.goldmen.home.map.legal.domain.Legal;
import com.goldmen.home.map.legal.service.LegalService;
import com.goldmen.home.map.vo.SeoulOpenDataMap;
import com.goldmen.home.mapper.BatchMapper;
import com.goldmen.home.metro.line.domain.Line;
import com.goldmen.home.metro.station.domain.Station;
import com.goldmen.home.station.vo.StationInfo;
import com.goldmen.home.vo.Position;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
@Service
public class MapService {
    private final SeoulOpenDataMapClient mapClient;

    private final DistrictService districtService;
    private final LegalService legalService;
    private final BatchMapper batchMapper;

    /**
     * 법정동 및 자치구 저장
     * @throws IOException
     */
    public void saveMap() throws IOException {
        List<SeoulOpenDataMap> mapList = mapClient.getSeoulOpenDataMapList();
        for (SeoulOpenDataMap map : mapList) {
            District district = districtService.saveDistrict(batchMapper.toDistrict(map));
            legalService.saveLegal(batchMapper.toLegal(map,district));
        }
    }
}
