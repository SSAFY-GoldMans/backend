package com.goldmen.common.type;

public class ClientResponse<T> {

    private T value;
    private Exception exception;

    private ClientResponse(T value) {
        this.value = value;
    }

    private ClientResponse(Exception e) {
        exception = e;
    }

    public static <T> ClientResponse<T> ok(T value) {
        return new ClientResponse<>(value);
    }

    public static <T> ClientResponse<T> failed(Exception e) {
        return new ClientResponse<>(e);
    }

    public T getOrDefault(T defaultValue) {
        if (hasException()) {
            return defaultValue;
        }
        return value;
    }

    public boolean isSuccess() {
        return !hasException();
    }

    public boolean hasException() {
        return exception != null;
    }
}