package com.goldmen.redisdomain.building.building.service;

import com.goldmen.jpadomain.building.building.domain.BuildingRepository;
import com.goldmen.redisdomain.building.building.fixture.BuildingFixture;
import com.goldmen.jpadomain.building.building.service.BuildingService;
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

@Transactional
@ExtendWith(MockitoExtension.class)
class BuildingServiceTest {
    @InjectMocks
    private BuildingService buildingService;

    @Mock
    private BuildingRepository buildingRepository;

    @DisplayName("저장 테스트")
    @Nested
    class saveTest{
        @Test
        @DisplayName("존재하지 않은 데이터 일 때")
        void whenNotExist(){
            /* GIVEN */
            given(buildingRepository.findFirstByOption(any())).willReturn(Optional.of(BuildingFixture.building1.createBuilding()));

            /* WHEN, THEN */
            assertDoesNotThrow(() ->{
                buildingService.save(BuildingFixture.building1.createBuilding());
            });
        }

        @Test
        @DisplayName("존재하는 데이터 일 때")
        void whenAlreadyExist(){
            /* GIVEN */
            given(buildingRepository.findFirstByOption(any())).willReturn(Optional.empty());
            given(buildingRepository.save(any())).willReturn(BuildingFixture.building1.createBuilding());

            /* WHEN, THEN */
            assertDoesNotThrow(() ->{
                buildingService.save(BuildingFixture.building1.createBuilding());
            });
        }
    }
}