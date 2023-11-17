package com.goldmen.home.map.district.domain;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@Transactional
@ExtendWith(SpringExtension.class)
@DataJpaTest
public class DistrictRepositoryTest {
    @Autowired
    private DistrictRepository districtRepository;

    @PersistenceContext
    private EntityManager em;

    @DisplayName("District 저장 테스트")
    @Nested
    class saveDistrictTest {
        @DisplayName("성공")
        @Test
        void whenSuccess() {
            District district = District.builder().code("1100").name("역삼역").build();
            districtRepository.save(district);
            em.flush();
            em.clear();
            assertEquals(1, districtRepository.findAll().size());
        }

        @DisplayName("실패, 코드가 없을 때")
        @Test
        void whenFailByCodeEmpty() {
            assertThrows(RuntimeException.class, () -> {
                District district = District.builder().code("").name("역삼역").build();
                districtRepository.save(district);
            });
        }

        @DisplayName("실패, 코드가 10글자이상일 때")
        @Test
        void whenFailByNameEmpty() {
            assertThrows(RuntimeException.class, () -> {
                District district = District.builder().code("1100123401235123").name("역삼역").build();
                districtRepository.save(district);
            });
        }
    }
}
