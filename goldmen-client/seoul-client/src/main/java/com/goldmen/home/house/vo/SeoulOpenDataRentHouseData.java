package com.goldmen.home.house.vo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record SeoulOpenDataRentHouseData(int listTotalCount, List<SeoulOpenDataRentHouse> seoulOpenDataRentHouseList) {
    @JsonCreator
    public SeoulOpenDataRentHouseData(
            @JsonProperty("list_total_count") int listTotalCount,
            @JsonProperty("row") List<SeoulOpenDataRentHouse> seoulOpenDataRentHouseList) {
        this.listTotalCount = listTotalCount;
        this.seoulOpenDataRentHouseList = seoulOpenDataRentHouseList;
    }
}