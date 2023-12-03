package com.goldmen.jpadomain.user.member.exception;

import com.goldmen.common.exception.ErrorCode;
import lombok.Getter;

@Getter
public enum MemberErrorCode implements ErrorCode {
    DUPLICATE_EMAIL(400, "Member_01", "이미 존재하는 이메일입니다.");
    private final int statusCode;
    private final String errorCode;
    private final String message;

    MemberErrorCode(int statusCode, String errorCode, String message) {
        this.statusCode = statusCode;
        this.errorCode = errorCode;
        this.message = message;
    }
}
