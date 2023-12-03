package com.goldmen.api.house.controller;

import com.goldmen.api.house.dto.request.GetHouseRequest;
import com.goldmen.api.house.dto.request.SaleableDetailRequest;
import com.goldmen.api.house.dto.response.GetHousePositionResponse;
import com.goldmen.api.house.dto.response.GetHouseResponse;
import com.goldmen.api.house.dto.response.SaleableDetailResponse;
import com.goldmen.api.house.service.HouseService;
import com.goldmen.common.type.ApiResponse;
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
        return ResponseEntity.ok(response);
    }

    @PostMapping("/position")
    public ResponseEntity<ApiResponse<GetHousePositionResponse>> getHousePositionList(@RequestBody GetHouseRequest request) {
        ApiResponse<GetHousePositionResponse> response = houseService.getHousePosition(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/detail")
    public ResponseEntity<ApiResponse<SaleableDetailResponse>> getSaleableDetail(@RequestBody SaleableDetailRequest request) {
        ApiResponse<SaleableDetailResponse> response = houseService.getSaleable(request);
        log.info(response.getBody().toString());
        return ResponseEntity.ok(response);
    }
}
