package com.goldmen.home.auth.data;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class AuthMember {
    private int id;

    public AuthMember(int id) {
        this.id = id;
    }
}
