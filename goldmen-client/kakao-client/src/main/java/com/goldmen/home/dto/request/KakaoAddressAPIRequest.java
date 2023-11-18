package com.goldmen.home.dto.request;

import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class KakaoAddressAPIRequest {
    private String sggNm;
    private String bjDongNm;
    private int bobn;
    private int bubn;

    public String makeRoadAddress() {
        return sggNm + " " + bjDongNm + " " +
                bobn + "-" + bubn;
    }
}
