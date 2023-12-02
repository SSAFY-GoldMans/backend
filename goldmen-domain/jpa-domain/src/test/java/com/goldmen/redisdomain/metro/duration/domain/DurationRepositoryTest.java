package com.goldmen.redisdomain.metro.duration.domain;

import com.goldmen.jpadomain.metro.duration.domain.Duration;
import com.goldmen.jpadomain.metro.duration.domain.DurationRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles("mysql")
class DurationRepositoryTest {
    @Autowired
    private DurationRepository durationRepository;

    @DisplayName("역 ID와 시간으로 Duration 목록 가져오기")
    @Test
    void findNearStationByStationIdAndTime() {
        int maxTime = 10;
        int targetStationId = 2583;
        List<Duration> durationList = durationRepository.findByStationByStationIdAndTime(targetStationId, maxTime);

        for (Duration duration : durationList) {
            assertThat(duration.getTime()).isLessThanOrEqualTo(maxTime);
            assertThat(duration.getStartStation().getId() == targetStationId ||
                    duration.getEndStation().getId() == targetStationId).isTrue();
//            assertTrue(duration.getTime() <= maxTime);
//            assertTrue(duration.getStartStation().getId() == targetStationId || duration.getEndStation().getId() == targetStationId);
        }
    }
}