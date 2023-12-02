package com.goldmen.redisdomain.station.vo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class StationInfo {

    private String stationName;
    private String stationCode;
    private String lineNum;
    private String frCode;

    @JsonCreator
    public StationInfo(
            @JsonProperty("station_nm") String stationName,
            @JsonProperty("station_cd") String stationCode,
            @JsonProperty("line_num") String lineNum,
            @JsonProperty("fr_code") String frCode) {
        this.stationName = stationName;
        this.stationCode = stationCode;
        this.lineNum = lineNum;
        this.frCode = frCode;
    }
}
