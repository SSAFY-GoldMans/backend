package com.goldmen.home.house.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.goldmen.home.building.global.domain.PriceEnum;

public record SaleableDetailRequest(
        @JsonProperty("type") PriceEnum priceEnum,
        @JsonProperty("id") int saleableId
) {
}
