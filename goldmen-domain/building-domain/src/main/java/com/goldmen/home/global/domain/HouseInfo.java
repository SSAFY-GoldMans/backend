package com.goldmen.home.global.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Embeddable
public class HouseInfo {
    @Column(nullable = false)
    private double area;
    @Column(nullable = false)
    private int floor;
}
