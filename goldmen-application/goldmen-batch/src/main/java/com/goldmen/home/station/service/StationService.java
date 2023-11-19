package com.goldmen.home.station.service;

import com.goldmen.home.mapper.BatchMapper;
import com.goldmen.home.station.vo.StationInfo;
import com.goldmen.home.map.legal.domain.Legal;
import com.goldmen.home.map.legal.service.LegalService;
import com.goldmen.home.metro.line.domain.Line;
import com.goldmen.home.metro.line.service.LineServiceImpl;
import com.goldmen.home.metro.station.domain.Station;
import com.goldmen.home.metro.station.service.StationServiceImpl;
import com.goldmen.home.service.KakaoMapService;
import com.goldmen.home.vo.Position;
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