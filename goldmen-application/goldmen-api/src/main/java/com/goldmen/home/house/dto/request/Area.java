package com.goldmen.home.house.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public class Area{

    private Integer max;

    private Integer min;
    public Area(@JsonProperty("max") Integer max, @JsonProperty("min") Integer min){
        this.max = (int)(max*3.3);
        this.min = (int)(min*3.3);
    }

    public Area() {

    }
}