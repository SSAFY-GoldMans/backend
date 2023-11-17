package com.goldmen.home.station.vo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.List;

@Getter
public class StationInfoRaw {
    private List<StationInfo> stationInfoList;

    @JsonCreator
    public StationInfoRaw(
            @JsonProperty("DATA") List<StationInfo> stationInfoList
    ){
        this.stationInfoList = stationInfoList;
    }
}
