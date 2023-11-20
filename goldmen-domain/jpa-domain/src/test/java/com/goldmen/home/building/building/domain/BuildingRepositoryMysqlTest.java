package com.goldmen.home.building.building.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Transactional(readOnly = true)
@ActiveProfiles({"mysql"})
@SpringBootTest
public class BuildingRepositoryMysqlTest {
    @Autowired
    private BuildingRepository buildingRepository;

    @DisplayName("위치 기준 주위 집 데이터 조회 테스트")
    @Test
    void findAllByLocationAndDistTestWhenSuccess(){
        assertDoesNotThrow(()->{
            List<Building> buildingList= buildingRepository.findAllByLocationAndDist(37.54040751726388,127.06920291650829, 800);
//            assertEquals(39,buildingList.size());
        });
    }
}
