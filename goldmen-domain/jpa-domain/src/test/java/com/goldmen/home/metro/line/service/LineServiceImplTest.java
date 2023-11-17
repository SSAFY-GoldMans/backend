package com.goldmen.home.metro.line.service;

import com.goldmen.home.metro.line.domain.Line;
import jakarta.transaction.Transactional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Transactional
@SpringBootTest
class LineServiceImplTest {
    @Autowired
    private LineModifyService lineModifyService;

    @DisplayName("지하철 호선 저장에 성공한다.")
    @Test
    void saveTestSuccess() {
        Line line = lineModifyService.save(Line.builder().name("12호선").build());
        Assertions.assertThat(line).isNotNull();
    }
}