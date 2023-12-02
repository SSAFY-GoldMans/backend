package com.goldmen.redisdomain.metro.station.service;

import com.goldmen.jpadomain.map.district.domain.District;
import com.goldmen.jpadomain.map.district.domain.DistrictRepository;
import com.goldmen.jpadomain.map.legal.domain.Legal;
import com.goldmen.jpadomain.map.legal.domain.LegalRepository;
import com.goldmen.jpadomain.metro.line.domain.Line;
import com.goldmen.jpadomain.metro.line.domain.LineRepository;
import com.goldmen.jpadomain.metro.station.domain.Station;
import com.goldmen.jpadomain.metro.station.domain.StationRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@Transactional
@SpringBootTest
class StationServiceImplTest {
    @Autowired
    private StationRepository stationRepository;
    @Autowired
    private LineRepository lineRepository;
    @Autowired
    private LegalRepository legalRepository;
    @Autowired
    private DistrictRepository districtRepository;

    @DisplayName("역 정보 저장")
    @Test
    void saveTestSuccess() {
        Line line = lineRepository.save(Line.builder().name("2호선").build());
        District district = districtRepository.save(District.builder().name("abc").code("1").build());
        Legal legal = legalRepository.save(Legal.builder().name("adb").code("0").district(district).build());

        Station station = Station.builder()
                .name("강남역")
                .lat(37.49808633653005)
                .lng(127.02800140627488)
                .code("222")
                .line(line)
                .legal(legal)
                .build();

        Station saveStation = stationRepository.save(station);

        assertThat(saveStation).isNotNull();
    }
}