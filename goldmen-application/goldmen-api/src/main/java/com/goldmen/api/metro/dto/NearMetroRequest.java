package com.goldmen.api.metro.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.goldmen.jpadomain.building.building.domain.BuildingEnum;
import com.goldmen.jpadomain.building.global.domain.PriceEnum;

public record NearMetroRequest(
        String name,
        int time,
        @JsonProperty("building") BuildingEnum buildingEnum, // APT, OFFICETEL
        @JsonProperty("type") PriceEnum priceEnum // MONTHLY, JEONSE
) {
}
