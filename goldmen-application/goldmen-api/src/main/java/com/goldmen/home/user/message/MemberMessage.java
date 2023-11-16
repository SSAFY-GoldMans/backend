package com.goldmen.home.user.message;

import com.goldmen.home.type.Message;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
public enum MemberMessage implements Message {
    SUCCESS_SIGNUP("회원가입에 성공하였습니다.");

    private String message;
}
