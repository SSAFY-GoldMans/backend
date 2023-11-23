package com.goldmen.home.auth.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Getter
@RedisHash(value = "token", timeToLive = 60 * 60 * 24 * 14)
public class Token {
    @Id
    private int id;
    private String value;
}
