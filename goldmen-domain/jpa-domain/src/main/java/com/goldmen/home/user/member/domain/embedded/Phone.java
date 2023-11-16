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
public class Phone {
    @Column(name = "phone", nullable = false, length = 15)
    private String value;

    public static Phone from(String phone) {
        return new Phone(phone);
    }
}
