package com.goldmen.home.metro.duration.domain;

import com.goldmen.home.metro.duration.domain.query.DurationRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DurationRepository extends JpaRepository<Duration, Integer>, DurationRepositoryCustom {
}
