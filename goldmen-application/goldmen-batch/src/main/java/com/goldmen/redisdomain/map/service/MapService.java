package com.goldmen.redisdomain.map.service;

import com.goldmen.jpadomain.map.district.domain.District;
import com.goldmen.jpadomain.map.district.service.DistrictService;
import com.goldmen.jpadomain.map.legal.service.LegalService;
import com.goldmen.redisdomain.map.vo.SeoulOpenDataMap;
import com.goldmen.redisdomain.mapper.BatchMapper;
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
