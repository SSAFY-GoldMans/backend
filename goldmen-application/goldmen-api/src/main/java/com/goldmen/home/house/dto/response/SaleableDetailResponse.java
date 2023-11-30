package com.goldmen.home.house.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.goldmen.home.building.monthly.domain.Monthly;
import com.goldmen.home.building.global.domain.Saleable;
import com.goldmen.home.building.jeonse.domain.Jeonse;

public record SaleableDetailResponse(
        @JsonProperty("id") int saleableId,
        @JsonProperty("img") String img,
        @JsonProperty("name") String name,
        @JsonProperty("price") String price,
        @JsonProperty("area") String area,
        @JsonProperty("floor") int floor,
        @JsonProperty("address") String address
) {
    public static SaleableDetailResponse from(Saleable saleable) {
        return new SaleableDetailResponse(
                saleable.getId(),
                null,
                saleable.getBuilding().getName(),
                convertPrice(saleable.getPrice()),
                convertArea(saleable.getArea()),
                saleable.getFloor(),
                convertAddress(saleable)
        );
    }

    private static String convertAddress(Saleable saleable) {
        if (saleable instanceof Jeonse jeonse) {
            return convertAddress(jeonse);
        }
        if (saleable instanceof Monthly monthly) {
            return convertAddress(monthly);
        }
        throw new RuntimeException();
    }

    private static String convertAddress(Jeonse jeonse) {
        return jeonse.getBuilding().getLegal().getDistrict().getName() + " "
                + jeonse.getBuilding().getLegal().getName() + " "
                + jeonse.getBuilding().getMainNumber() + " - "
                + jeonse.getBuilding().getSubNumber();
    }

    private static String convertAddress(Monthly monthly) {
        return monthly.getBuilding().getLegal().getDistrict().getName() + " "
                + monthly.getBuilding().getLegal().getName() + " "
                + monthly.getBuilding().getMainNumber() + " - "
                + monthly.getBuilding().getSubNumber();
    }

    private static String convertArea(double area) {
        return String.format("%d평", Math.round(area / 3.3));
    }

    private static String convertPrice(int price) {
        if (price >= 1e4) return Math.round(price / 1e4) + "억원";
        else return price + "만원";
    }
}