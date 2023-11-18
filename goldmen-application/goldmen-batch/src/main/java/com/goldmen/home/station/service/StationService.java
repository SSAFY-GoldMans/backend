package com.goldmen.home.station.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.goldmen.home.station.dto.response.StationInfoResponse;
import com.goldmen.home.station.vo.StationInfo;
import com.goldmen.home.dto.request.KaKaoKeywordAPIRequest;
import com.goldmen.home.map.legal.domain.Legal;
import com.goldmen.home.map.legal.service.LegalService;
import com.goldmen.home.metro.line.domain.Line;
import com.goldmen.home.metro.line.service.LineServiceImpl;
import com.goldmen.home.metro.station.domain.Station;
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
    private final SeoulOpenDataStationClient stationClient;
    private final KakaoMapService kakaoService;
    private final StationServiceImpl stationService;
    private final LineServiceImpl lineService;
    private final LegalService legalService;

    private final ObjectMapper objectMapper;

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
            Position position = getPositionByKeyword(stationInfo.getStationName());
            Line line = lineService.find(Line.builder().name(stationInfo.getStationName()).build());
            Legal legal = legalService.findLegal(Legal.builder().name(position.getLegalName()).build());
            stationService.save(Station
                    .builder()
                    .name(stationInfo.getStationName())
                    .lat(position.getLongitude())
                    .lat(position.getLatitude())
                    .code(Integer.parseInt(stationInfo.getStationCode()))
                    .line(line)
                    .legal(legal)
                    .build()
            );
        }
    }
}