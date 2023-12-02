package com.goldmen.redisdomain.building.building.domain;

import com.goldmen.jpadomain.building.building.data.cond.FindBuildingOptionCond;
import com.goldmen.redisdomain.building.building.fixture.BuildingFixture;
import com.goldmen.jpadomain.building.building.domain.Building;
import com.goldmen.jpadomain.building.building.domain.BuildingRepository;
import com.goldmen.jpadomain.map.district.domain.District;
import com.goldmen.jpadomain.map.district.domain.DistrictRepository;
import com.goldmen.redisdomain.map.district.fixture.DistrictFixture;
import com.goldmen.jpadomain.map.legal.domain.Legal;
import com.goldmen.jpadomain.map.legal.domain.LegalRepository;
import com.goldmen.redisdomain.map.legal.fixture.LegalFixture;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@Transactional
@DataJpaTest
class BuildingRepositoryTest {
    @Autowired
    private BuildingRepository buildingRepository;
    @Autowired
    private DistrictRepository districtRepository;
    @Autowired
    private LegalRepository legalRepository;

    @PersistenceContext
    private EntityManager em;

    private District district;
    private Legal legal;

    private Building building;

    @BeforeEach
    void setUp(){
        district = districtRepository.save(DistrictFixture.district1.createDistrict());
        legal = legalRepository.save(LegalFixture.legal1.createLegal(district));
        building = BuildingFixture.building1.createBuilding(legal);
    }

    @DisplayName("빌딩 데이터 찾기 테스트")
    @Nested
    class findByOption{

        @DisplayName("기존 데이터가 있을 때")
        @Test
        void SuccessWhenAlreadyExist() {
            buildingRepository.save(building);
            em.flush();
            em.clear();
            em.close();
            assertTrue(buildingRepository.findFirstByOption(FindBuildingOptionCond.from(building)).isPresent());
        }

        @DisplayName("기존 데이터가 없을 때")
        @Test
        void FailWhenNotExist() {
            assertTrue(buildingRepository.findFirstByOption(FindBuildingOptionCond.from(building)).isEmpty());
        }

        @DisplayName("기존 데이터와 다를 때")
        @Test
        void WhenAlreadyExist() {
            /* GIVEN */
            buildingRepository.save(building);
            Building anotherBuilding = BuildingFixture.building2.createBuilding(legal);
            em.flush();
            em.clear();
            em.close();

            /* WHEN, THEN */
            assertTrue(buildingRepository.findFirstByOption(FindBuildingOptionCond.from(anotherBuilding)).isEmpty());
        }
    }
}