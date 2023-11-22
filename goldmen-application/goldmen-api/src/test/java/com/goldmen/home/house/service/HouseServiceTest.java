package com.goldmen.home.house.service;

import com.goldmen.home.building.building.domain.BuildingEnum;
import com.goldmen.home.building.global.domain.Saleable;
import com.goldmen.home.building.jeonse.domain.Jeonse;
import com.goldmen.home.house.dto.request.Area;
import com.goldmen.home.house.dto.request.GetHouseRequest;
import com.goldmen.home.house.dto.request.Price;
import com.goldmen.home.house.dto.request.Rent;
import com.goldmen.home.house.dto.response.GetHouseResponse;
import com.goldmen.home.type.ApiResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("mysql")
@SpringBootTest
class HouseServiceTest {

    @Autowired
    private HouseService houseService;

    @Test
    void getHouse() {
        GetHouseRequest request = new GetHouseRequest(BuildingEnum.OFFICETEL,"Monthly","역삼",new Price(null,null),new Area(null,null),new Rent(null,null));
        assertDoesNotThrow(() -> {
            ApiResponse<GetHouseResponse> response = houseService.getHouse(request);
            System.out.println( response.getBody().getHouseList().size());
        });
    }
}