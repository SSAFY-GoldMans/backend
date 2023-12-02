package com.goldmen.redisdomain.auth.service;

import com.goldmen.redisdomain.auth.domain.Token;

public interface TokenModifyService {
    Token save(Token token);

    void deleteById(int id);
}
