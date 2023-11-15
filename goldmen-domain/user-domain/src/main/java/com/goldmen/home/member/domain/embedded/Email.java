package com.goldmen.home.member.domain.embedded;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Embeddable
public class Email {
    @Column(name = "email", nullable = false, length = 50)
    private String value;

    private Email(String value) {
        this.value = value;
    }

    public static Email from(String email) {
        return new Email(email);
    }
}
