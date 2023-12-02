package com.goldmen.api.user.member.service;

import com.goldmen.api.user.member.dto.request.MemberLoginRequest;
import com.goldmen.api.user.member.dto.request.MemberSignupRequest;
import com.goldmen.api.user.member.mapper.MemberMapper;
import com.goldmen.api.auth.data.dto.request.LoginRequest;
import com.goldmen.api.auth.data.dto.response.TokenResponse;
import com.goldmen.api.auth.service.AuthService;
import com.goldmen.common.type.ApiResponse;
import com.goldmen.jpadomain.user.member.domain.Member;
import com.goldmen.api.user.member.dto.request.MemberDeleteRequest;
import com.goldmen.api.user.member.dto.request.MemberUpdateRequest;
import com.goldmen.jpadomain.user.member.service.MemberLoadService;
import com.goldmen.jpadomain.user.member.service.MemberModifyService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import static com.goldmen.api.user.message.MemberMessage.*;

@RequiredArgsConstructor
@Service
public class MemberService {
    private final MemberModifyService memberModifyService;
    private final MemberLoadService memberLoadService;

    private final MemberMapper mapper;
    private final PasswordEncoder passwordEncoder;
    private final AuthService authService;

    public ApiResponse<String> signup(MemberSignupRequest request) {
        Member member = mapper.toJpaEntity(request, passwordEncoder);
        memberModifyService.save(member);

        return ApiResponse.noContent()
                .addMessage(SUCCESS_SIGNUP);
    }

    public ApiResponse<TokenResponse> login(MemberLoginRequest request) {
        return ApiResponse.valueOf(authService.login(
                        new LoginRequest(request.email(), request.password())))
                .addMessage(SUCCESS_LOGIN);
    }

    public ApiResponse<String> update(int id, MemberUpdateRequest request) {
        if (!request.newPassword().equals(request.validateNewPassword())) {
            throw new RuntimeException();   // 새로운 비밀번호 불일치
        }
        Member findMember = memberLoadService.findById(id);
        if (passwordEncoder.matches(request.currentPassword(), findMember.getPassword())) {
            memberModifyService.update(findMember, request.newPassword());
            return ApiResponse.noContent()
                    .addMessage(SUCCESS_PASSWORD_UPDATE);
        }
        throw new RuntimeException();   // 현재 비밀번호 불일치
    }

    public ApiResponse<Boolean> delete(MemberDeleteRequest request) {
        boolean isSuccess = memberModifyService.delete(request.id(), request.password());
        return ApiResponse.valueOf(isSuccess);
    }
}
