package com.goldmen.home.map.legal.domain;

import com.goldmen.home.map.district.domain.District;
import com.goldmen.home.map.district.domain.DistrictRepository;
import com.goldmen.home.map.district.fixture.DistrictFixture;
import com.goldmen.home.map.legal.fixture.LegalFixture;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@Transactional
@DataJpaTest
class LegalRepositoryTest {
    @Autowired
    private LegalRepository legalRepository;
    @Autowired
    private DistrictRepository districtRepository;

    @PersistenceContext
    private EntityManager em;

    @DisplayName("Legal 저장 테스트")
    @Nested
    class SaveDistrictTest {
        @Transactional
        @DisplayName("성공")
        @Test
        void whenSuccess() {
            District district = districtRepository.save(DistrictFixture.district1.createDistrict());
            legalRepository.save(LegalFixture.legal1.createLegal(district));

            em.flush();
            em.clear();
            em.close();

            assertEquals(1, legalRepository.findAll().size());
        }

        @Transactional
        @DisplayName("District 없어서 실패")
        @Test
        void whenFailByNotExistDistrict() {
            assertThrows(RuntimeException.class, () -> {
                District district = DistrictFixture.district1.createDistrict();
                legalRepository.save(LegalFixture.legal1.createLegal(district));
                em.flush();
                em.clear();
            });
        }
    }
}