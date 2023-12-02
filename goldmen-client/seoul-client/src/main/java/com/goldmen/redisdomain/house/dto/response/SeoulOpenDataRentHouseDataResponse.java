package com.goldmen.redisdomain.house.dto.response;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.goldmen.redisdomain.house.vo.SeoulOpenDataRentHouseData;

public record SeoulOpenDataRentHouseDataResponse(SeoulOpenDataRentHouseData seoulOpenDataRentHouseData) {
    @JsonCreator
    public SeoulOpenDataRentHouseDataResponse(@JsonProperty("tbLnOpendataRentV") SeoulOpenDataRentHouseData seoulOpenDataRentHouseData) {
        this.seoulOpenDataRentHouseData = seoulOpenDataRentHouseData;
    }
}
