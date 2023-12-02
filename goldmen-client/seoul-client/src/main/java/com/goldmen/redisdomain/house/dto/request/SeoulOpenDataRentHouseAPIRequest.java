package com.goldmen.redisdomain.house.dto.request;

import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Getter
public class SeoulOpenDataRentHouseAPIRequest {
    private int start;
    private int end;
    private int size;

    public static SeoulOpenDataRentHouseAPIRequest healthCheckRequest() {
        return SeoulOpenDataRentHouseAPIRequest.builder()
                .start(1)
                .end(1)
                .size(0)
                .build();
    }

    public static SeoulOpenDataRentHouseAPIRequest toRequest(int index, int size) {
        return SeoulOpenDataRentHouseAPIRequest.builder()
                .start(index)
                .end(index + size)
                .size(size)
                .build();
    }
}
