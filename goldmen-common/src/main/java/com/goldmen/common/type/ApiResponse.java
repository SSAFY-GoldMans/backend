package com.goldmen.common.type;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class ApiResponse<T> {
    private final List<String> messages = new ArrayList<>();
    private final T body;

    private ApiResponse(T value) {
        this.body = value;
    }

    public static <T> ApiResponse<T> valueOf(T value) {
        return new ApiResponse<>(value);
    }

    public static ApiResponse<String> noContent() {
        return new ApiResponse<>("No Content");
    }

    public ApiResponse<T> addMessage(Message message) {
        messages.add(message.getMessage());
        return this;
    }

    public ApiResponse<T> addMessage(List<Message> messages) {
        for (Message message : messages) {
            this.messages.add(message.getMessage());
        }
        return this;
    }

}
