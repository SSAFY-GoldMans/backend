package com.goldmen.home.house.vo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

public record SeoulOpenDataHouseWrapper(SeoulOpenDataHouseData seoulOpenDataHouseData) {
    @JsonCreator
    public SeoulOpenDataHouseWrapper(@JsonProperty("tbLnOpendataRentV") SeoulOpenDataHouseData seoulOpenDataHouseData) {
        this.seoulOpenDataHouseData = seoulOpenDataHouseData;
    }
}
