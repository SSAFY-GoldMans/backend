package com.goldmen.jpadomain.building.global.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Getter
@Embeddable
public class HouseInfo {
    @Column(nullable = false)
    private double area;
    @Column(nullable = false)
    private int floor;
}
