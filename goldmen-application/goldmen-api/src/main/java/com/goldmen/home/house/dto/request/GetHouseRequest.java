package com.goldmen.home.house.dto.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class GetHouseRequest {
    private String buildingType;

    private String rentType = "월세";

    private String stationName;
    private Price price;

    private Area area;

    private Rent rent;

    @JsonCreator
    public GetHouseRequest(@JsonProperty("buildingType") String buildingType, @JsonProperty("rentType") String rentType, @JsonProperty("stationName") String stationName,
                           @JsonProperty(value = "price") Price price, @JsonProperty("area") Area area, @JsonProperty("rent") Rent rent) {
        this.buildingType = buildingType;
        this.rentType = rentType;
        this.stationName = stationName;
        if (price == null) this.price = new Price();
        else this.price = price;
        if (area == null) this.area = new Area();
        else this.area = area;
        if (rent == null) this.rent = new Rent();
        else this.rent = rent;
    }
}
