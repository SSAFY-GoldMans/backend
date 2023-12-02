package com.goldmen.api.metro.dto;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record NearMetroResponse(
        @JsonProperty("name") String stationName,
        @JsonProperty("time") String time,
        @JsonProperty("address") String address,
        @JsonProperty("price") String middlePrice,
        @JsonProperty("lat") double lat,
        @JsonProperty("lng") double lng,
        @JsonProperty("count") int count,
        @JsonProperty("lines") List<Integer> lines
) {
}
