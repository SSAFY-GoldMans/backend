package com.goldmen.redisdomain.auth.service;

import com.goldmen.redisdomain.auth.domain.Token;

public interface TokenLoadService {
    Token findById(int id);
}
