package com.goldmen.home.metro.station.domain;

import com.goldmen.home.metro.line.domain.Line;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StationRepository extends JpaRepository<Station, Integer> {

    boolean existsByNameAndLine(String name, Line line);
}
