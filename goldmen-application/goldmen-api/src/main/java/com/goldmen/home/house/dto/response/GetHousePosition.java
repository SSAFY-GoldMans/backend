package com.goldmen.home.house.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.goldmen.home.building.global.domain.Saleable;

public record GetHousePosition(
        @JsonProperty("id") int buildingId,
        @JsonProperty("name") String name,
        @JsonProperty("lnt") double lat,
        @JsonProperty("lng") double lng
) {
    static public GetHousePosition saleableToGetHouseResponse(Saleable saleable) {
        return new GetHousePosition(saleable.getId(), saleable.getBuilding().getName(), saleable.getBuilding().getLat(), saleable.getBuilding().getLng());
    }
}
