package com.goldmen.home.house.dto.response;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.goldmen.home.house.vo.SeoulOpenDataRentHouseData;

public record SeoulOpenDataRentHouseDataResponse(SeoulOpenDataRentHouseData seoulOpenDataRentHouseData) {
    @JsonCreator
    public SeoulOpenDataRentHouseDataResponse(@JsonProperty("tbLnOpendataRentV") SeoulOpenDataRentHouseData seoulOpenDataRentHouseData) {
        this.seoulOpenDataRentHouseData = seoulOpenDataRentHouseData;
    }
}
