package com.goldmen.home.map.legal.service;

import com.goldmen.home.map.district.domain.District;
import com.goldmen.home.map.district.domain.DistrictRepository;
import com.goldmen.home.map.district.service.DistrictService;
import com.goldmen.home.map.legal.domain.Legal;
import com.goldmen.home.map.legal.domain.LegalRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
@Transactional
class LegalServiceTest {
    @InjectMocks
    private LegalService legalService;

    @Mock
    private LegalRepository legalRepository;

    @DisplayName("District 저장 테스트")
    @Nested
    class getDistrictTest{
        @DisplayName("성공")
        @Test
        void whenSuccessByAlreadyExist(){
            /* GIVEN */
            District district = District.builder().code("1100").name("역삼역").build();
            Legal legal = Legal.builder().code("0011").name("강남구").district(district).build();
            given(legalRepository.findByCode(any())).willReturn(Optional.of(legal));

            /* WHEN */
            Legal gotLegal = legalService.getLegal(legal);

            /* THEN */
            assertEquals(legal.getCode(),gotLegal.getCode());
        }

        @DisplayName("저장 후 추출")
        @Test
        void whenSuccessBySave(){
            /* GIVEN */
            District district = District.builder().code("1100").name("역삼역").build();
            Legal legal = Legal.builder().code("0011").name("강남구").district(district).build();
            given(legalRepository.findByCode(any())).willReturn(Optional.empty());
            given(legalRepository.save(legal)).willReturn(legal);

            /* WHEN */
            Legal gotLegal = legalService.getLegal(legal);

            /* THEN */
            assertEquals(legal.getCode(),gotLegal.getCode());
        }
    }
}