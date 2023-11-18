package com.goldmen.home.house.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RentHouseServiceTest {
    @Autowired
    private RentHouseService rentHouseService;

    @Test
    void saveHouseDatas() {
        assertDoesNotThrow(() -> {
            rentHouseService.saveHouseDatas(1000);
        });
    }
}