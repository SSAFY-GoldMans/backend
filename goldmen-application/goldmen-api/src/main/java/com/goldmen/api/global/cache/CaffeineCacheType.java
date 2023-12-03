package com.goldmen.api.global.cache;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum CaffeineCacheType {
    STATION_INFO("station_info", 100, 10000),
    ;

    private final String cacheName;
    private final int expireTime;
    private final int maximumSize;
}
