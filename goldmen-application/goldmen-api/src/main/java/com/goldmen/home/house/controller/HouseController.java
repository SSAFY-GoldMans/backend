package com.goldmen.home.house.controller;

import com.goldmen.home.house.dto.request.GetHouseRequest;
import com.goldmen.home.house.dto.response.GetHousePositionResponse;
import com.goldmen.home.house.dto.response.GetHouseResponse;
import com.goldmen.home.house.service.HouseService;
import com.goldmen.home.type.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/house")
public class HouseController {
    private final HouseService houseService;

    @PostMapping
    public ResponseEntity<ApiResponse<GetHouseResponse>> getHouseList(@RequestBody GetHouseRequest request) {
        ApiResponse<GetHouseResponse> response = houseService.getHouse(request);
        log.info(response.getBody().getHouseList().toString());
        return ResponseEntity.ok(response);
    }

    @PostMapping("/position")
    public ResponseEntity<ApiResponse<GetHousePositionResponse>> getHousePositionList(@RequestBody GetHouseRequest request) {
        ApiResponse<GetHousePositionResponse> response = houseService.getHousePosition(request);
        log.info(response.getBody().housePositionList().toString());
        return ResponseEntity.ok(response);
    }
}

