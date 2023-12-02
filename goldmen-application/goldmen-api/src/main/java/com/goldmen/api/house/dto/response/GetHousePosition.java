package com.goldmen.api.house.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.goldmen.jpadomain.building.global.domain.Saleable;

public record GetHousePosition(
        @JsonProperty("id") int buildingId,
        @JsonProperty("name") String name,
        @JsonProperty("lat") double lat,
        @JsonProperty("lng") double lng
) {
    public static GetHousePosition saleableToGetHouseResponse(Saleable saleable) {
        return new GetHousePosition(saleable.getId(), saleable.getBuilding().getName(), saleable.getBuilding().getLat(), saleable.getBuilding().getLng());
    }
}
