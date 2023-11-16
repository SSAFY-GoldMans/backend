package com.goldmen.home.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class Position {

    private String longitude;

    private String latitude;

    public Position (@JsonProperty("x") String longitude, @JsonProperty("y") String latitude){
        this.latitude = latitude;
        this.longitude = longitude;
    }
}
