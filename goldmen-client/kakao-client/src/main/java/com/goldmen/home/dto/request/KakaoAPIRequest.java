package com.goldmen.home.dto.request;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
public class KakaoAPIRequest{
    private String query;

    public static KakaoAPIRequest toRequest(String query) {
        return new KakaoAPIRequest(query);
    }
}
