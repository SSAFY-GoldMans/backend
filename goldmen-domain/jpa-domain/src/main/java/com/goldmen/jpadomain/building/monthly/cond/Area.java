package com.goldmen.jpadomain.building.monthly.cond;

import lombok.Getter;

@Getter
public class Area {
    private final int max;
    private final int min;

    public Area(Integer max, Integer min) {
        if (max == null) this.max = (int) (1_000 * 3.3);
        else this.max = max;
        if (min == null) this.min = 0;
        else this.min = min;
    }
}