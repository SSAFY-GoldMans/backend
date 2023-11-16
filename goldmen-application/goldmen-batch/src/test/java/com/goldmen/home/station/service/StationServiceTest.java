package com.goldmen.home.station.service;

import com.goldmen.home.station.vo.StationInfo;
import com.goldmen.home.station.vo.StationInfoRaw;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class StationServiceTest {
    @Autowired
    private StationService stationService;

    @DisplayName("역정보를 추출하는데 성공한다.")
    @Test
    void getStationInfoTestWhenSuccess() throws IOException {
        List<StationInfo> stationInfos = stationService.getStationInformationFile("stationInformation.json");
        assertEquals("01호선",stationInfos.get(0).getLineNum());
        assertEquals("병점",stationInfos.get(0).getStationName());
        assertEquals("1716",stationInfos.get(0).getStationCode());
        assertEquals("P157",stationInfos.get(0).getFrCode());
    }
}
