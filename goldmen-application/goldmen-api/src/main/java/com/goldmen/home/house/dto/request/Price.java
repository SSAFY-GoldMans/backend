package com.goldmen.home.house.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class Price {

    private Integer max;

    private Integer min;

    public Price(@JsonProperty(value = "max", defaultValue = "1000000") Integer max, @JsonProperty(value = "min",defaultValue = "0") Integer min){
        this.max = max;
        this.min = min;
    }

    public Price(){}

}
