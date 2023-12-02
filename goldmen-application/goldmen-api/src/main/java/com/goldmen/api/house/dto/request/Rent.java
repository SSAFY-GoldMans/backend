package com.goldmen.api.house.dto.request;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Rent{

    private Integer max = 10;

    private Integer min = 0;

    public Rent(@JsonProperty("max") Integer max, @JsonProperty("min") Integer min){
        this.max = max;
        this.min = min;
    }

    public Rent() {

    }
}
