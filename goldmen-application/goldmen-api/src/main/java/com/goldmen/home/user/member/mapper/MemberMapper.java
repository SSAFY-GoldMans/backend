package com.goldmen.home.user.member.mapper;

import com.goldmen.home.user.member.domain.Member;
import com.goldmen.home.user.member.domain.embedded.Email;
import com.goldmen.home.user.member.domain.embedded.Password;
import com.goldmen.home.user.member.domain.embedded.Phone;
import com.goldmen.home.user.member.dto.request.MemberSignupRequest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class MemberMapper {
    /* TODO: 비밀번호 암호화 */

    public Member toJpaEntity(MemberSignupRequest request, PasswordEncoder passwordEncoder) {
        return Member.builder()
                .email(Email.from(request.email()))
                .password(Password.from(passwordEncoder.encode(request.password())))
                .phone(Phone.from(request.phone()))
                .role(request.role())
                .build();
    }
}
