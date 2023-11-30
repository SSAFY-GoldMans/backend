package com.goldmen.home.building.monthly.cond;

import lombok.Getter;

@Getter
public class Price {
    private final int max;
    private final int min;

    public Price(Integer max, Integer min) {
        if (max == null) this.max = 1_000_000;
        else this.max = max;
        if (min == null) this.min = 0;
        else this.min = min;
    }
}
