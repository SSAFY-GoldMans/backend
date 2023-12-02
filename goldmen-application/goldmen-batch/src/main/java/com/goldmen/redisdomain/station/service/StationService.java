package com.goldmen.redisdomain.station.service;

import com.goldmen.redisdomain.mapper.BatchMapper;
import com.goldmen.redisdomain.station.vo.StationInfo;
import com.goldmen.jpadomain.map.legal.domain.Legal;
import com.goldmen.jpadomain.map.legal.service.LegalService;
import com.goldmen.jpadomain.metro.line.domain.Line;
import com.goldmen.jpadomain.metro.line.service.LineServiceImpl;
import com.goldmen.jpadomain.metro.station.service.StationServiceImpl;
import com.goldmen.redisdomain.service.KakaoMapService;
import com.goldmen.redisdomain.vo.Position;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class StationService {
    private final SeoulOpenDataStationClient stationClient;
    private final KakaoMapService kakaoService;
    private final StationServiceImpl stationService;
    private final LineServiceImpl lineService;
    private final LegalService legalService;
    private final BatchMapper batchMapper;

    private List<StationInfo> getStationInformation() throws IOException {
        return stationClient.getStationInformationFile();
    }

    public void saveStation() throws IOException {
        List<StationInfo> stationInfoList = getStationInformation();
        for (StationInfo stationInfo : stationInfoList) {
            Position position = kakaoService.getPosition(batchMapper.toKakaoKeywordAPIRequest(stationInfo.getStationName()));
            if (!position.inSeoul()) continue;
            Line line = lineService.save(batchMapper.toLine(stationInfo));
            Legal legal = legalService.findByNameAndDistrictName(position.getLegalName(), position.getDistrictName());
            stationService.save(batchMapper.toStation(stationInfo, position, line, legal));
        }
    }
}