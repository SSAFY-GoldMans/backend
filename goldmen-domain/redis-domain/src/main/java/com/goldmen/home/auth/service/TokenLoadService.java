package com.goldmen.home.auth.service;

import com.goldmen.home.auth.domain.Token;

public interface TokenLoadService {
    Token findById(int id);
}
