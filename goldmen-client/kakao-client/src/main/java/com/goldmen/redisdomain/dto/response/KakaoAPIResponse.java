package com.goldmen.redisdomain.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.goldmen.redisdomain.vo.Position;
import lombok.Getter;

import java.util.List;

@Getter
public class KakaoAPIResponse {
    @JsonProperty
    private List<Position> positionList;

    public KakaoAPIResponse (@JsonProperty("documents") List<Position> positionList){
        this.positionList = positionList;
    }
}