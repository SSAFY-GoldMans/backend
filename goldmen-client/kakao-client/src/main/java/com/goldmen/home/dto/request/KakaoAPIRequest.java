package com.goldmen.home.dto.request;

import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class KakaoAPIRequest {
    private String sggNm;
    private String bjDongNm;
    private String bobn;
    private String bubn;

    public String makeRoadAddress() {
        return sggNm + " " + bjDongNm + " " +
                bobn + "-" + bubn;
    }
}
