package com.goldmen.home.house.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.goldmen.home.building.building.domain.BuildingEnum;

public record SaleableDetailRequest(
        @JsonProperty("type") BuildingEnum buildingEnum,
        @JsonProperty("id") int saleableId
) {
}
