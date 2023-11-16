package com.goldmen.home.house.service;

import com.goldmen.home.house.dto.request.SeoulOpenDataHouseAPIRequest;
import com.goldmen.home.house.vo.SeoulOpenDataHouse;
import com.goldmen.home.house.vo.SeoulOpenDataHouseData;
import com.goldmen.home.house.dto.response.SeoulOpenDataHouseDataResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class SeoulOpenDataHouseClient {
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

    /**
     * 전/월세 집 중 필요한 데이터만 추출하기 위한 필터링기능
     *
     * @param seoulOpenDataHouseList 공공데이터 API의 전/월세집 데이터
     * @return {@link SeoulOpenDataHouse}
     */
    public List<SeoulOpenDataHouse> filteringHouse(List<SeoulOpenDataHouse> seoulOpenDataHouseList) {
        return seoulOpenDataHouseList.stream()
                .filter(house -> !house.rentGbn().equals("매매"))
                .filter(house -> house.cntrctPrd().isEmpty())
                .filter(house -> house.bobn() != null && !house.bobn().isEmpty())
                .filter(house -> house.bubn() != null && !house.bubn().isEmpty())
                .filter(house -> house.bjdongCd() != null && !house.bjdongCd().isEmpty())
                .filter(house -> house.bjdongNm() != null && !house.bjdongNm().isEmpty())
                .filter(house -> house.sggCd() != null && !house.sggCd().isEmpty())
                .filter(house -> house.sggNm() != null && !house.sggNm().isEmpty())
                .filter(house -> house.rentGtn() != null && !house.rentGtn().equals("0"))
                .filter(house -> house.buildYear() != null && !house.buildYear().isEmpty())
                .filter(house -> house.rentArea() != null && house.rentArea() != 0D)
                .filter(house -> house.flrNo() != null && house.flrNo() != 0D)
                .collect(Collectors.toList());
    }
}
