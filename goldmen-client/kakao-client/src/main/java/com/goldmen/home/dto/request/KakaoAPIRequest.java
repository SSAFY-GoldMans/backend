package com.goldmen.home.dto.request;

import lombok.*;

@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class KakaoAPIRequest{
    private String sggNm;
    private String bjDongNm;
    private String bobn;
    private String bubn;

    public String makeRoadAddress() {
        StringBuilder sb = new StringBuilder()
                .append(sggNm).append(" ")
                .append(bjDongNm).append(" ")
                .append(bobn).append("-")
                .append(bubn);
        return sb.toString();
    }
}
