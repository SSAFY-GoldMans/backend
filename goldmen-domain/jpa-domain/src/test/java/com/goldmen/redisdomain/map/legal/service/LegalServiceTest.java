package com.goldmen.redisdomain.map.legal.service;

import com.goldmen.jpadomain.map.legal.domain.Legal;
import com.goldmen.jpadomain.map.legal.domain.LegalRepository;
import com.goldmen.redisdomain.map.legal.fixture.LegalFixture;
import com.goldmen.jpadomain.map.legal.service.LegalService;
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
class LegalServiceTest {
    @InjectMocks
    private LegalService legalService;

    @Mock
    private LegalRepository legalRepository;

    private final Legal legal = LegalFixture.legal1.createLegal();

    @DisplayName("Legal 조회 테스트")
    @Nested
    class findLegalTest {
        @DisplayName("성공")
        @Test
        void whenSuccessByAlreadyExist() {
            /* GIVEN */
            given(legalRepository.findByCodeAndDistrict(any(),any())).willReturn(Optional.of(legal));

            /* WHEN */
            Legal gotLegal = legalService.findByCodeAndDistrict(legal);

            /* THEN */
            assertEquals(legal.getCode(), gotLegal.getCode());
        }

        @DisplayName("실패")
        @Test
        void whenFail() {
            /* GIVEN */
            given(legalRepository.findByCodeAndDistrict(any(),any())).willReturn(Optional.empty());
            /* WHEN , THEN*/
            assertThrows(NoSuchElementException.class, () -> {
                Legal gotLegal = legalService.findByCodeAndDistrict(legal);
            });
        }
    }

    @DisplayName("Legal 저장 테스트")
    @Nested
    class saveLegalTest {
        @DisplayName("성공")
        @Test
        void whenSuccessByAlreadyExist() {
            /* GIVEN */
            given(legalRepository.findByCodeAndDistrict(any(),any())).willReturn(Optional.of(legal));

            /* WHEN, THEN */
            assertDoesNotThrow(()->{
                legalService.findByCodeAndDistrict(legal);
            });
        }

        @DisplayName("저장 후 추출")
        @Test
        void whenSuccessBySave() {
            /* GIVEN */
            given(legalRepository.findByCodeAndDistrict(any(),any())).willReturn(Optional.empty());

            /* WHEN , THEN */
            assertThrows(NoSuchElementException.class, () -> {
                legalService.findByCodeAndDistrict(legal);
            });
        }
    }
}