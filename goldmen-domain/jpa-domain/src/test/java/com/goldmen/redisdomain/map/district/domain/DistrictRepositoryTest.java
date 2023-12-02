package com.goldmen.redisdomain.map.district.domain;

import com.goldmen.redisdomain.map.district.fixture.DistrictFixture;
import com.goldmen.jpadomain.map.district.domain.District;
import com.goldmen.jpadomain.map.district.domain.DistrictRepository;
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

import java.util.List;

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
    class saveTest {
        @DisplayName("성공")
        @Test
        void whenSuccess() {
            District district = DistrictFixture.district1.createDistrict();
            districtRepository.save(district);
            em.flush();
            em.clear();
            assertEquals(1, districtRepository.findAll().size());
        }

        @DisplayName("실패, 이미 저장되어 있을 때")
        @Test
        void whenFailByAlreadyExist() {
            District district = DistrictFixture.district1.createDistrict();
            districtRepository.save(district);
            em.flush();
            em.clear();
            assertThrows(RuntimeException.class,()->{
                districtRepository.save(DistrictFixture.district1.createDistrict());
            });
        }

        @DisplayName("실패, 코드가 없을 때")
        @Test
        void whenFailByCodeEmpty() {
            assertThrows(RuntimeException.class, () -> {
                District district = DistrictFixture.districtBlankCode.createDistrict();
                districtRepository.save(district);
            });
        }

        @DisplayName("실패, 코드가 10글자이상일 때")
        @Test
        void whenFailByNameEmpty() {
            assertThrows(RuntimeException.class, () -> {
                District district = DistrictFixture.districtTooLongCode.createDistrict();
                districtRepository.save(district);
            });
        }
    }

    @DisplayName("District 조회 테스트")
    @Nested
    class findByCodeTest{
        @DisplayName("성공")
        @Test
        void whenSuccess(){
            District district = DistrictFixture.district1.createDistrict();
            districtRepository.save(district);
            em.flush();
            em.clear();
            em.close();
            assertTrue(districtRepository.findByCode(district.getCode()).isPresent());
        }

        @Test
        void whatIsThat(){
            District district = DistrictFixture.district1.createDistrict();
            districtRepository.save(district);
            em.flush();
            em.clear();
            em.close();
            District savedDistrict = districtRepository.findByCode(district.getCode()).orElse(districtRepository.save(district));
            List<District> districtList = districtRepository.findAll();
            assertEquals(district.getCode(),savedDistrict.getCode());
            assertEquals(1,districtList.size());
        }
    }

}
