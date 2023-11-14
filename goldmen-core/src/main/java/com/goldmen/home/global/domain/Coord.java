package com.goldmen.home.global.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Getter
@Embeddable
public class Coord {
    @Column(nullable = false)
    private double lat;

    @Column(nullable = false)
    private double lng;
}
