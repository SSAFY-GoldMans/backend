package com.goldmen.home.map.dto.response;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.goldmen.home.map.vo.SeoulOpenDataMap;
import lombok.Getter;

import java.util.List;

@Getter
public class SeoulOpenDataMapResponse {
    private final List<SeoulOpenDataMap> seoulOpenDataMapList;

    @JsonCreator
    public SeoulOpenDataMapResponse(
            @JsonProperty("DATA") List<SeoulOpenDataMap> seoulOpenDataMapList
    ) {
        this.seoulOpenDataMapList = seoulOpenDataMapList;
    }
}
