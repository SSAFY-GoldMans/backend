package com.goldmen.home.house.dto;

import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Getter
public class SeoulOpenDataHouseAPIRequest {
    private int start;
    private int end;
    private int size;

    public static SeoulOpenDataHouseAPIRequest healthCheckRequest() {
        return SeoulOpenDataHouseAPIRequest.builder()
                .start(1)
                .end(1)
                .size(0)
                .build();
    }

    public static SeoulOpenDataHouseAPIRequest toRequest(int index, int size) {
        return SeoulOpenDataHouseAPIRequest.builder()
                .start(index)
                .end(index + size)
                .size(size)
                .build();
    }
}
