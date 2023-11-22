package com.goldmen.home.building.Monthly.cond;

import lombok.Builder;
import lombok.Getter;

@Getter
public class FindAllCondition {
    private final String buildingType;
    private final Price price;
    private final Area area;
    private final Rent rent;

    @Builder
    public FindAllCondition(String buildingType, Price price, Rent rent, Area area) {
        this.buildingType = buildingType;
        this.price = price;
        this.rent = rent;
        this.area = area;
    }
}
