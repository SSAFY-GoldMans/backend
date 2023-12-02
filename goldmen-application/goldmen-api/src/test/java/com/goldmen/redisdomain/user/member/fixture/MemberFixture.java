package com.goldmen.redisdomain.user.member.fixture;

import com.goldmen.jpadomain.user.member.domain.Role;
import com.goldmen.api.user.member.dto.request.MemberLoginRequest;
import com.goldmen.api.user.member.dto.request.MemberSignupRequest;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum MemberFixture {
    정욱("workju1124@gmail.com", "qwerty1234!@", "qwerty1234!@", "01012345678", Role.USER);

    private String email;
    private String password;
    private String validatePassword;
    private String phone;
    private Role role;

    public MemberSignupRequest 회원가입_요청을_생성한다() {
        return new MemberSignupRequest(email, password, validatePassword, phone, role);
    }

    public MemberLoginRequest 로그인_요청을_생성한다() {
        return new MemberLoginRequest(email, password);
    }
}