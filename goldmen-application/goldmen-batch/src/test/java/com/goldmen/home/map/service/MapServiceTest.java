package com.goldmen.home.map.service;

import com.goldmen.home.map.district.service.DistrictService;
import com.goldmen.home.map.legal.domain.LegalRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles({"test"})
@SpringBootTest
class MapServiceTest {

    @Autowired
    private MapService mapService;

    @Test
    void saveMap() {
        assertDoesNotThrow(()->{
            mapService.saveMap();
        });
    }
}