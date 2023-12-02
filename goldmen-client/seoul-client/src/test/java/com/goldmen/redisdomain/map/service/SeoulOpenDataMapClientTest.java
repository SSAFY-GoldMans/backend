package com.goldmen.redisdomain.map.service;

import com.goldmen.redisdomain.map.vo.SeoulOpenDataMap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles({"test"})
@SpringBootTest
class SeoulOpenDataMapClientTest {
    @Autowired
    private SeoulOpenDataMapClient mapClient;

    @DisplayName("자치구및 법정동 코드 정보를 추출하는데 성공한다.")
    @Test
    void getStationInfoTestWhenSuccess() throws IOException {
        assertDoesNotThrow(()-> {
            List<SeoulOpenDataMap> mapList = mapClient.getSeoulOpenDataMapList();
            System.out.println(mapList.get(0));
        });

    }
}