package com.goldmen.home.house.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;

@AllArgsConstructor
@Builder
class GetHouse {
    @JsonProperty
    private int houseId;

    @JsonProperty
    private String houseName;

    @JsonProperty
    private String price;

    @JsonProperty
    private String address;

    @JsonProperty
    private int floor;

    @JsonProperty
    private String area;

    @JsonProperty
    private String year;

    @JsonProperty
    private String img;
}
