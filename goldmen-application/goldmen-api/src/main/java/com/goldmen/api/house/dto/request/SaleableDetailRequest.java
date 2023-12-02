package com.goldmen.api.house.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.goldmen.jpadomain.building.global.domain.PriceEnum;

public record SaleableDetailRequest(
        @JsonProperty("type") PriceEnum priceEnum,
        @JsonProperty("id") int saleableId
) {
}
