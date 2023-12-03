package com.goldmen.jpadomain.global.exception;

import com.goldmen.common.exception.ErrorCode;
import com.goldmen.common.exception.GoldmenException;

public class JpaDomainException extends GoldmenException {
    public JpaDomainException(ErrorCode code) {
        super(code);
    }
}
