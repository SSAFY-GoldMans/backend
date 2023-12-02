package com.goldmen.common.exception;

import lombok.Getter;

@Getter
public class GoldmenException extends RuntimeException {
    private final int statusCode;
    private final String errorCode;
    private final String message;

    public GoldmenException(ErrorCode code) {
        statusCode = code.getStatusCode();
        errorCode = code.getErrorCode();
        message = code.getMessage();
    }
}
