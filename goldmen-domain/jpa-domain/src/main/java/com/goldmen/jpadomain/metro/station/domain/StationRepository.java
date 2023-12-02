package com.goldmen.jpadomain.metro.station.domain;

import com.goldmen.jpadomain.metro.line.domain.Line;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StationRepository extends JpaRepository<Station, Integer> {
    boolean existsByNameAndLine(String name, Line line);

    Optional<Station> findByName(String name);

    Optional<Station> findFirstByName(String name);
}
