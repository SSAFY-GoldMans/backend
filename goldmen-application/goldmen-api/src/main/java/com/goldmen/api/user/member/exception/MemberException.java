package com.goldmen.api.user.member.exception;

import com.goldmen.common.exception.ErrorCode;
import com.goldmen.common.exception.GoldmenException;

public class MemberException extends GoldmenException {
    public MemberException(ErrorCode code) {
        super(code);
    }
}
