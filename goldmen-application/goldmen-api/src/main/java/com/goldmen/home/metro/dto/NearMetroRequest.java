package com.goldmen.home.metro.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.goldmen.home.building.building.domain.BuildingEnum;
import com.goldmen.home.building.global.domain.PriceEnum;

public record NearMetroRequest(
        String name,
        int time,
        @JsonProperty("building") BuildingEnum buildingEnum, // APT, OFFICETEL
        @JsonProperty("type") PriceEnum priceEnum // MONTHLY, JEONSE
) {
}
