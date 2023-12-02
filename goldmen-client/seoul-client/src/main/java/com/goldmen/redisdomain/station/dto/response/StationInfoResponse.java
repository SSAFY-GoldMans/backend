package com.goldmen.redisdomain.station.dto.response;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.goldmen.redisdomain.station.vo.StationInfo;
import lombok.Getter;

import java.util.List;

@Getter
public class StationInfoResponse {
    private List<StationInfo> stationInfoList;

    @JsonCreator
    public StationInfoResponse(
            @JsonProperty("DATA") List<StationInfo> stationInfoList
    ){
        this.stationInfoList = stationInfoList;
    }
}