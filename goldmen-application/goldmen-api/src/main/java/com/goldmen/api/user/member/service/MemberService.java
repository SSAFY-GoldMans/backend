package com.goldmen.api.user.member.service;

import com.goldmen.api.auth.data.dto.request.LoginRequest;
import com.goldmen.api.auth.data.dto.response.TokenResponse;
import com.goldmen.api.auth.service.AuthService;
import com.goldmen.api.user.member.dto.request.MemberDeleteRequest;
import com.goldmen.api.user.member.dto.request.MemberLoginRequest;
import com.goldmen.api.user.member.dto.request.MemberSignupRequest;
import com.goldmen.api.user.member.dto.request.MemberUpdateRequest;
import com.goldmen.api.user.member.exception.MemberErrorCode;
import com.goldmen.api.user.member.exception.MemberException;
import com.goldmen.api.user.member.mapper.MemberMapper;
import com.goldmen.common.type.ApiResponse;
import com.goldmen.jpadomain.user.member.domain.Member;
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

    /**
     * @throws com.goldmen.jpadomain.global.exception.JpaDomainException 이미 존재하는 회원이면 예외를 던진다.
     */
    public ApiResponse<String> signup(MemberSignupRequest request) {
        Member member = mapper.toJpaEntity(request, passwordEncoder);
        memberModifyService.save(member);

        return ApiResponse.noContent()
                .addMessage(SUCCESS_SIGNUP);
    }

    public ApiResponse<TokenResponse> login(MemberLoginRequest request) {
        return ApiResponse.valueOf(authService.login(new LoginRequest(request.email(), request.password())))
                .addMessage(SUCCESS_LOGIN);
    }

    /**
     * @throws MemberException 사용자의 비밀번호가 일치하지 않으면 예외를 던짐
     */
    public ApiResponse<String> update(int id, MemberUpdateRequest request) {
        validateInputPassword(request);

        Member findMember = memberLoadService.findById(id);
        validatePassword(request, findMember);
        memberModifyService.update(findMember, request.newPassword());

        return ApiResponse.noContent()
                .addMessage(SUCCESS_PASSWORD_UPDATE);
    }

    private void validateInputPassword(MemberUpdateRequest request) {
        if (!request.newPassword().equals(request.validateNewPassword())) {
            throw new MemberException(MemberErrorCode.PASSWORD_IS_NOT_SAME);
        }
    }

    private void validatePassword(MemberUpdateRequest request, Member findMember) {
        if (!passwordEncoder.matches(request.currentPassword(), findMember.getPassword())) {
            throw new MemberException(MemberErrorCode.PASSWORD_IS_NOT_SAME);
        }
    }

    public ApiResponse<Boolean> delete(MemberDeleteRequest request) {
        boolean isSuccess = memberModifyService.delete(request.id(), request.password());
        return ApiResponse.valueOf(isSuccess);
    }
}
