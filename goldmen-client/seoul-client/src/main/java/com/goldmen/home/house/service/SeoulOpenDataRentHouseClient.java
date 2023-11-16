package com.goldmen.home.house.service;

import com.goldmen.home.house.dto.request.SeoulOpenDataHouseAPIRequest;
import com.goldmen.home.house.vo.SeoulOpenDataHouseData;
import com.goldmen.home.house.dto.response.SeoulOpenDataHouseDataResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@RequiredArgsConstructor
@Component
public class SeoulOpenDataRentHouseClient {
    @Value("${seoulOpenDateKey}")
    private String key;

    /**
     * 공공데이터에서 전세집 데이터를 추출한다.
     */
    public SeoulOpenDataHouseData fetchAPI(SeoulOpenDataHouseAPIRequest request) {
        String urlBuilder = "http://openapi.seoul.go.kr:8088"
                + '/' + URLEncoder.encode(key, StandardCharsets.UTF_8)
                + '/' + URLEncoder.encode("json", StandardCharsets.UTF_8)
                + '/' + URLEncoder.encode("tbLnOpendataRentV", StandardCharsets.UTF_8)
                + '/' + URLEncoder.encode(String.valueOf(request.getStart()), StandardCharsets.UTF_8)
                + '/' + URLEncoder.encode(String.valueOf(request.getEnd()), StandardCharsets.UTF_8);

        RestTemplate restTemplate = new RestTemplate();
        SeoulOpenDataHouseDataResponse wrapper = restTemplate.getForObject(urlBuilder, SeoulOpenDataHouseDataResponse.class);
        return wrapper.seoulOpenDataHouseData();
    }
}
