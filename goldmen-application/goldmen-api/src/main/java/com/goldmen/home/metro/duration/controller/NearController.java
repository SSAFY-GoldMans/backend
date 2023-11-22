package com.goldmen.home.metro.duration.controller;

import com.goldmen.home.metro.dto.NearMetroRequest;
import com.goldmen.home.metro.dto.NearMetroResponse;
import com.goldmen.home.metro.service.NearService;
import com.goldmen.home.type.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/near")
@RequiredArgsConstructor
@RestController
public class NearController {
    private final NearService nearService;

    @PostMapping
    public ResponseEntity<ApiResponse<List<NearMetroResponse>>> nearStation(@RequestBody NearMetroRequest request) {
        System.out.println(request);
        ApiResponse<List<NearMetroResponse>> response = nearService.getNearMetroList(request);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
