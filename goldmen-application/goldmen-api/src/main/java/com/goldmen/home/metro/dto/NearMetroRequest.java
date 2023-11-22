package com.goldmen.home.metro.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record NearMetroRequest(
        String name,
        int time,
        @JsonProperty("building") String buildingType, // APT, OFFICETEL
        @JsonProperty("type") String priceType // MONTHLY, JEONSE
) {
}
