package com.goldmen.home.user.member.fixture;

import com.goldmen.home.user.member.domain.Member;
import com.goldmen.home.user.member.domain.Role;
import com.goldmen.home.user.member.domain.embedded.Email;
import com.goldmen.home.user.member.domain.embedded.Password;
import com.goldmen.home.user.member.domain.embedded.Phone;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum MemberFixture {
    정욱("workju1124@gmail.com", "qwerty1234!@", "01012345678", Role.USER);

    private String email;
    private String password;
    private String phone;
    private Role role;

    public Member 사용자를_생성한다() {
        return Member.builder()
                .email(Email.from(email))
                .password(Password.from(password))
                .phone(Phone.from(phone))
                .role(role)
                .build();
    }
}
