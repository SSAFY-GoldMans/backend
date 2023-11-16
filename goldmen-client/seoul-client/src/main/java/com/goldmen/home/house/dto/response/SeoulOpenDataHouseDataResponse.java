package com.goldmen.home.house.dto.response;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.goldmen.home.house.vo.SeoulOpenDataHouseData;

public record SeoulOpenDataHouseDataResponse(SeoulOpenDataHouseData seoulOpenDataHouseData) {
    @JsonCreator
    public SeoulOpenDataHouseDataResponse(@JsonProperty("tbLnOpendataRentV") SeoulOpenDataHouseData seoulOpenDataHouseData) {
        this.seoulOpenDataHouseData = seoulOpenDataHouseData;
    }
}
