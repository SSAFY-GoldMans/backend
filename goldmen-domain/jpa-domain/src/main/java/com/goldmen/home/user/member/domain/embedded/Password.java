package com.goldmen.home.user.member.domain.embedded;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Embeddable
public class Password {
    @Column(name = "password", nullable = false)
    private String value;

    public static Password from(String password) {
        return new Password(password);
    }
}
