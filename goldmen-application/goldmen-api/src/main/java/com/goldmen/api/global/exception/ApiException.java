package com.goldmen.api.global.exception;

import com.goldmen.common.exception.ErrorCode;
import com.goldmen.common.exception.GoldmenException;

public class ApiException extends GoldmenException {
    public ApiException(ErrorCode code) {
        super(code);
    }
}
