package com.goldmen.home.metro.line.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LineRepository extends JpaRepository<Line, Integer> {
    Optional<Line> findByName(String name);
}
