package com.goldmen.redisdomain.auth.service;

import com.goldmen.redisdomain.auth.domain.Token;
import com.goldmen.redisdomain.auth.domain.TokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class TokenService
        implements TokenLoadService, TokenModifyService {
    private final TokenRepository tokenRepository;

    @Override
    public Token findById(int id) {
        return tokenRepository.findById(id)
                .orElseThrow(RuntimeException::new);
    }

    @Override
    public Token save(Token token) {
        return tokenRepository.save(token);
    }

    @Override
    public void deleteById(int id) {
        tokenRepository.deleteById(id);
    }
}
