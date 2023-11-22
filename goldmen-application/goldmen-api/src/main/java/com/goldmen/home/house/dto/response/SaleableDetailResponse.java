package com.goldmen.home.house.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public record SaleableDetailResponse(
        @JsonProperty("id") int saleableId,
        @JsonProperty("img") String img,
        @JsonProperty("name") String name,
        @JsonProperty("price") String price,
        @JsonProperty("area") String area,
        @JsonProperty("floor") int floor,
        @JsonProperty("address") String address
) {
}