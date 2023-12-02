package com.goldmen.jpadomain.user.member.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
public enum Role {
    USER("ROLE_USER", "회원"),
    AGENT("ROLE_AGENT", "중개업자"),
    ADMIN("ROLE_ADMIN", "관리자");

    private String value;
    private String name;
}
