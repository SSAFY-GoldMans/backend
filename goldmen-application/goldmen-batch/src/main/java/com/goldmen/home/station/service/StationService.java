package com.goldmen.home.station.service;

import com.goldmen.home.dto.request.KaKaoKeywordAPIRequest;
import com.goldmen.home.metro.line.domain.Line;
import com.goldmen.home.metro.line.service.LineServiceImpl;
import com.goldmen.home.metro.station.service.StationServiceImpl;
import com.goldmen.home.service.KakaoMapService;
import com.goldmen.home.station.vo.StationInfo;
import com.goldmen.home.vo.Position;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
@Service
public class StationService {
    private SeoulOpenDataStationClient stationClient;
    private KakaoMapService kakaoService;
    private StationServiceImpl stationService;
    private LineServiceImpl lineService;

    private List<StationInfo> getStationInformation() throws IOException {
        return stationClient.getStationInformationFile();
    }

    private Position getPositionByKeyword(String keyword) {
        KaKaoKeywordAPIRequest request = KaKaoKeywordAPIRequest.builder().keyword(keyword).build();
        return kakaoService.getPosition(request);
    }

    public void saveStation() throws IOException {
        List<StationInfo> stationInfoList = getStationInformation();
        for (StationInfo stationInfo : stationInfoList) {
            Line line = lineService.find(Line.builder().name(stationInfo.getStationName()).build());
        }
        /// TODO: 2023-11-17 stationService.saveStation();
    }
}