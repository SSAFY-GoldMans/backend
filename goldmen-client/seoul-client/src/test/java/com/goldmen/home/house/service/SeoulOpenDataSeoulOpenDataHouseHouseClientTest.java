package com.goldmen.home.house.service;

import com.goldmen.home.house.dto.SeoulOpenDataHouseAPIRequest;
import com.goldmen.home.house.vo.SeoulOpenDataHouseData;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles({"test"})
@SpringBootTest
class SeoulOpenDataSeoulOpenDataHouseHouseClientTest {
    @Autowired
    private SeoulOpenDataRentHouseClient client;

    @Test
    void fetchApiTestWhenSuccess() {
        SeoulOpenDataHouseAPIRequest request = SeoulOpenDataHouseAPIRequest.toRequest(1, 4);
        SeoulOpenDataHouseData seoulOpenDataHouseData = client.fetchAPI(request);
        assertEquals(5,seoulOpenDataHouseData.rowList().size());
    }
}