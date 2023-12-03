package com.goldmen.api.user.member.exception;

import com.goldmen.common.exception.ErrorCode;
import lombok.Getter;

@Getter
public enum MemberErrorCode implements ErrorCode {
    PASSWORD_IS_NOT_SAME(400, "MEMBER_01", "비밀번호가 일치하지 않습니다."),
    ;

    private final int statusCode;
    private final String errorCode;
    private final String message;

    MemberErrorCode(int statusCode, String errorCode, String message) {
        this.statusCode = statusCode;
        this.errorCode = errorCode;
        this.message = message;
    }
}
