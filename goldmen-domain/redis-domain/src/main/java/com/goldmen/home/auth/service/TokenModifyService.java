package com.goldmen.home.auth.service;

import com.goldmen.home.auth.domain.Token;

public interface TokenModifyService {
    Token save(Token token);

    void deleteById(int id);
}
