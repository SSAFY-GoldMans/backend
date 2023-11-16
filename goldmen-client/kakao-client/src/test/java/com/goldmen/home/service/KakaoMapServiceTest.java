package com.goldmen.home.service;

import com.goldmen.home.vo.Position;
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
        Position position = kakaoMapService.getPosition("은평구","불광동","0105","0076");
        assertNotNull(position);
    }
}
