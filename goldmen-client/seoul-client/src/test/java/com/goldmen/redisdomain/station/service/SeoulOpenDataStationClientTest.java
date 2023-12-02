package com.goldmen.redisdomain.station.service;

import com.goldmen.redisdomain.station.vo.StationInfo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("test")
@SpringBootTest
public class SeoulOpenDataStationClientTest {
    @Autowired
    private SeoulOpenDataStationClient stationClient;

    @DisplayName("역정보를 추출하는데 성공한다.")
    @Test
    void getStationInfoTestWhenSuccess() throws IOException {
        List<StationInfo> stationInfos = stationClient.getStationInformationFile();
        assertEquals("01호선", stationInfos.get(0).getLineNum());
        assertEquals("병점", stationInfos.get(0).getStationName());
        assertEquals("1716", stationInfos.get(0).getStationCode());
        assertEquals("P157", stationInfos.get(0).getFrCode());
    }
}
