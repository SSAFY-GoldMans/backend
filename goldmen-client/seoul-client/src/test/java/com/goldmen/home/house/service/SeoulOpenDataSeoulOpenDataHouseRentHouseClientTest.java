package com.goldmen.home.house.service;

import com.goldmen.home.house.dto.request.SeoulOpenDataRentHouseAPIRequest;
import com.goldmen.home.house.vo.SeoulOpenDataRentHouseData;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ActiveProfiles({"test"})
@SpringBootTest
class SeoulOpenDataSeoulOpenDataHouseRentHouseClientTest {
    @Autowired
    private SeoulOpenDataRentHouseClient client;


    @Test
    void fetchApiTestWhenSuccess() {
        SeoulOpenDataRentHouseAPIRequest request = SeoulOpenDataRentHouseAPIRequest.toRequest(1, 4);
        SeoulOpenDataRentHouseData seoulOpenDataRentHouseData = client.fetchAPI(request);
        assertEquals(5, seoulOpenDataRentHouseData.seoulOpenDataRentHouseList().size());
    }
}