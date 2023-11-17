package com.goldmen.home.map.district.service;

import com.goldmen.home.map.district.domain.District;
import com.goldmen.home.map.district.domain.DistrictRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
@Transactional
class DistrictServiceTest {
    @InjectMocks
    private DistrictService districtService;

    @Mock
    private DistrictRepository districtRepository;

    @DisplayName("District 저장 테스트")
    @Nested
    class getDistrictTest{
        @DisplayName("성공")
        @Test
        void whenSuccessByAlreadyExist(){
            /* GIVEN */
            District district = District.builder().code("1100").name("역삼역").build();
            given(districtRepository.findByCode(any())).willReturn(Optional.of(district));

            /* WHEN */
            District gotDistrict = districtService.getDistrict(district);

            /* THEN */
            assertEquals(district.getCode(),gotDistrict.getCode());
        }

        @DisplayName("저장 후 추출")
        @Test
        void whenSuccessBySave(){
            /* GIVEN */
            District district = District.builder().code("1100").name("역삼역").build();
            given(districtRepository.findByCode(any())).willReturn(Optional.empty());
            given(districtRepository.save(district)).willReturn(district);

            /* WHEN */
            District gotDistrict = districtService.getDistrict(district);

            /* THEN */
            assertEquals(district.getCode(),gotDistrict.getCode());
        }
    }
}