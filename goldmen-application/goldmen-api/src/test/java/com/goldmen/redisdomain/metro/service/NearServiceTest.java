package com.goldmen.redisdomain.metro.service;

import com.goldmen.api.metro.service.NearService;
import com.goldmen.jpadomain.building.building.domain.BuildingEnum;
import com.goldmen.jpadomain.building.global.domain.PriceEnum;
import com.goldmen.api.metro.dto.NearMetroRequest;
import com.goldmen.api.metro.dto.NearMetroResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

@SpringBootTest
@ActiveProfiles("mysql")
class NearServiceTest {
    @Autowired
    private NearService nearService;

    @Test
    @DisplayName("근처 역 가져오는 테스트 성공")
    void getNearMetroListTestSuccess() {
        NearMetroRequest request = new NearMetroRequest("역삼역", 10, BuildingEnum.APT, PriceEnum.JEONSE);

        List<NearMetroResponse> responseList = nearService.getNearMetroList(request).getBody();

        for (NearMetroResponse response : responseList) {
            System.out.println(response);
        }
    }
}