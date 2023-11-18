package com.goldmen.home.house.service;

import com.goldmen.home.house.dto.request.SeoulOpenDataRentHouseAPIRequest;
import com.goldmen.home.house.vo.SeoulOpenDataRentHouse;
import com.goldmen.home.house.vo.SeoulOpenDataRentHouseData;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ActiveProfiles({"test"})
@SpringBootTest
class SeoulOpenDataSeoulOpenDataHouseRentHouseClientTest {
    @Autowired
    private SeoulOpenDataRentHouseClient client;

    @DisplayName("전/월세 집 데이터 추출")
    @Test
    void fetchApiTestWhenSuccess() {
        SeoulOpenDataRentHouseAPIRequest request = SeoulOpenDataRentHouseAPIRequest.toRequest(1, 4);
        SeoulOpenDataRentHouseData seoulOpenDataRentHouseData = client.fetchAPI(request);
        assertEquals(5, seoulOpenDataRentHouseData.seoulOpenDataRentHouseList().size());
    }

    @DisplayName("전/월세 집 데이터 필터링")
    @Test
    void filteringHouseTestWhenSuccess(){
        SeoulOpenDataRentHouseAPIRequest request = SeoulOpenDataRentHouseAPIRequest.toRequest(1, 999);
        SeoulOpenDataRentHouseData seoulOpenDataRentHouseData = client.fetchAPI(request);
        List<SeoulOpenDataRentHouse> filteredSeoulOpenDataRentHouse = client.filteringHouse(seoulOpenDataRentHouseData.seoulOpenDataRentHouseList());
        assertTrue(1 <= filteredSeoulOpenDataRentHouse.size());
    }
}