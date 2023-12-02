package com.goldmen.api.house.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class Price {

    private Integer max;

    private Integer min;

    public Price(@JsonProperty(value = "max", defaultValue = "10000") Integer max, @JsonProperty(value = "min",defaultValue = "0") Integer min){
        this.max = max;
        this.min = min;
    }

    public Price(){}

}
