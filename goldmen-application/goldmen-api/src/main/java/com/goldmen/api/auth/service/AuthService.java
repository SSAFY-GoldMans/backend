package com.goldmen.api.auth.service;


import com.goldmen.api.auth.data.AuthMember;
import com.goldmen.api.auth.data.dto.request.LoginRequest;
import com.goldmen.api.auth.data.dto.request.ReissueRequest;
import com.goldmen.api.auth.data.dto.response.TokenResponse;
import com.goldmen.api.auth.support.TokenProvider;
import com.goldmen.redisdomain.auth.domain.Token;
import com.goldmen.redisdomain.auth.service.TokenLoadService;
import com.goldmen.redisdomain.auth.service.TokenModifyService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class AuthService {

    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final TokenProvider tokenProvider;
    private final TokenLoadService tokenLoadService;
    private final TokenModifyService tokenModifyService;

    public TokenResponse login(LoginRequest request) {
        UsernamePasswordAuthenticationToken authenticationToken = request.toAuthentication();

        Authentication authenticate = authenticationManagerBuilder
                .getObject()
                .authenticate(authenticationToken);

        TokenResponse response = tokenProvider.generateTokenResponse(authenticate);

        int memberId = Integer.parseInt(authenticate.getName());

        Token token = Token.builder()
                .id(memberId)
                .value(response.getRefreshToken())
                .build();

        tokenModifyService.save(token);
        return response;
    }


    public void logout(AuthMember authMember) {
        tokenModifyService.deleteById(authMember.getId());
    }


    public TokenResponse reissue(ReissueRequest request) {
        if (!tokenProvider.validateToken(request.getRefreshToken())) {
            throw new RuntimeException();
        }

        Authentication authentication = tokenProvider.getAuthentication(request.getAccessToken());

        int id = Integer.parseInt(authentication.getName());
        Token refreshToken = tokenLoadService.findById(id);

        if (!refreshToken.getValue().equals(request.getRefreshToken())) {
            throw new RuntimeException();
        }

        TokenResponse response = tokenProvider.generateTokenResponse(authentication);

        Token newRefreshToken = Token.builder()
                .id(id)
                .value(response.getRefreshToken())
                .build();

        tokenModifyService.save(newRefreshToken);

        return response;
    }
}
