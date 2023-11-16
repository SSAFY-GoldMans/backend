package com.goldmen.home.user.member.fixture;

import com.goldmen.home.user.member.domain.Role;
import com.goldmen.home.user.member.dto.request.MemberSignupRequest;
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
}