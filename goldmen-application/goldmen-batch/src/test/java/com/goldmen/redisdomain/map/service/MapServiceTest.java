package com.goldmen.redisdomain.map.service;

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