package com.goldmen.redisdomain.service;

import com.goldmen.redisdomain.dto.request.KaKaoKeywordAPIRequest;
import com.goldmen.redisdomain.dto.request.KakaoAddressAPIRequest;
import com.goldmen.redisdomain.vo.Position;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class KakaoMapServiceTest {
    @Autowired
    private KakaoMapService kakaoMapService;

    @DisplayName("kakaoAPI로 좌표 가져오기")
    @Test
    void getPositionWhenSuccess() {
        KakaoAddressAPIRequest request = KakaoAddressAPIRequest.builder().sggNm("은평구").bjDongNm("불광동").bobn("0105").bubn("0076").build();
        Position position = kakaoMapService.getPosition(request);
        System.out.println(position);
        assertNotNull(position);
    }

    @DisplayName("kakaoAPI로 좌표 가져오기(키워드 검색)")
    @Test
    void getPositionWhenSuccessByKeyword() {
        KaKaoKeywordAPIRequest request = KaKaoKeywordAPIRequest.builder().keyword("강남역").build();
        Position position = kakaoMapService.getPosition(request);
        System.out.println(position);
        assertNotNull(position);
    }
}
