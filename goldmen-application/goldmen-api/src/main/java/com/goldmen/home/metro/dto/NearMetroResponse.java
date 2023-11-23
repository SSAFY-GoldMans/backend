package com.goldmen.home.metro.dto;


import com.fasterxml.jackson.annotation.JsonProperty;

public record NearMetroResponse(
        @JsonProperty("name") String stationName,
        @JsonProperty("time") String time,
        @JsonProperty("address") String address,
        @JsonProperty("price") String middlePrice,
        @JsonProperty("lat") double lat,
        @JsonProperty("lng") double lng,
        @JsonProperty("count") int count
) {
}
