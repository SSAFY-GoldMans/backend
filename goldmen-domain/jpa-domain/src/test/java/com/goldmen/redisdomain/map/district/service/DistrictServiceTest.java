package com.goldmen.redisdomain.map.district.service;

import com.goldmen.jpadomain.map.district.domain.District;
import com.goldmen.jpadomain.map.district.domain.DistrictRepository;
import com.goldmen.redisdomain.map.district.fixture.DistrictFixture;
import com.goldmen.jpadomain.map.district.service.DistrictService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;
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

    @DisplayName("District 조회 테스트")
    @Nested
    class findDistrictTest{
        @DisplayName("성공")
        @Test
        void whenSuccess(){
            /* GIVEN */
            District district = DistrictFixture.district1.createDistrict();
            given(districtRepository.findByCode(any())).willReturn(Optional.of(district));

            /* WHEN */
            District gotDistrict = districtService.findDistrict(district);

            /* THEN */
            assertEquals(district.getCode(),gotDistrict.getCode());
        }

        @DisplayName("실패")
        @Test
        void whenFail(){
            /* GIVEN */
            District district = DistrictFixture.district1.createDistrict();
            given(districtRepository.findByCode(any())).willReturn(Optional.empty());

            /* WHEN, THEN */
            assertThrows(NoSuchElementException.class,() -> {
                districtService.findDistrict(district);
            });

        }
    }

    @DisplayName("District 저장 테스트")
    @Nested
    class saveDistrictTest{
        @DisplayName("이미 존재해서 성공")
        @Test
        void whenSuccessByExist(){
            /* GIVEN */
            District district = DistrictFixture.district1.createDistrict();
            given(districtRepository.findByCode(any())).willReturn(Optional.of(district));

            /* WHEN */
            District gotDistrict = districtService.saveDistrict(district);

            /* THEN */
            assertEquals(district.getCode(),gotDistrict.getCode());
        }

        @DisplayName("저장후 성공")
        @Test
        void whenSuccessBySave(){
            /* GIVEN */
            District district = DistrictFixture.district1.createDistrict();
            given(districtRepository.findByCode(any())).willReturn(Optional.empty());
            given(districtRepository.save(any())).willReturn(district);

            /* WHEN */
            District gotDistrict = districtService.saveDistrict(district);

            /* THEN */
            assertEquals(district.getCode(),gotDistrict.getCode());
        }
    }
}