package com.goldmen.home.auth.domain;

import org.springframework.data.repository.CrudRepository;

public interface TokenRepository extends CrudRepository<Token, Integer> {
}
