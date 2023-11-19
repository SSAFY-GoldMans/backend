package com.goldmen.home.station.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.goldmen.home.dto.request.KaKaoKeywordAPIRequest;
import com.goldmen.home.map.district.domain.District;
import com.goldmen.home.map.district.service.DistrictService;
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
import java.util.NoSuchElementException;

@RequiredArgsConstructor
@Service
public class StationService {
    private final SeoulOpenDataStationClient stationClient;
    private final KakaoMapService kakaoService;
    private final StationServiceImpl stationService;
    private final LineServiceImpl lineService;
    private final LegalService legalService;
    private final DistrictService districtService;

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
            Position position = getPositionByKeyword(stationInfo.getStationName() + "역");
            if (!position.inSeoul()) continue;
            try {
                Line line = lineService.findByName(Line.builder().name(stationInfo.getLineNum()).build());
                District district = districtService.findDistrictByName(District.builder().name(position.getDistrictName()).build());
                Legal legal = legalService.findByNameAndDistrictName(position.getLegalName(), district.getName());
                stationService.save(Station
                        .builder()
                        .name(stationInfo.getStationName())
                        .lng(position.getLongitude())
                        .lat(position.getLatitude())
                        .code(stationInfo.getStationCode())
                        .line(line)
                        .legal(legal)
                        .build()
                );
            } catch (NoSuchElementException e) {
                System.out.println(position);
                System.out.println("error: " + e.getMessage());
            }
        }
    }
}