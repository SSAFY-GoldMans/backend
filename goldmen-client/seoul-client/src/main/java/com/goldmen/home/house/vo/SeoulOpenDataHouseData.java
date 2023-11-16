package com.goldmen.home.house.vo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.List;

public record SeoulOpenDataHouseData(int listTotalCount, List<SeoulOpenDataHouse> rowList) {
    @JsonCreator
    public SeoulOpenDataHouseData(
            @JsonProperty("list_total_count") int listTotalCount,
            @JsonProperty("row") List<SeoulOpenDataHouse> rowList) {
        this.listTotalCount = listTotalCount;
        this.rowList = rowList;
    }
}