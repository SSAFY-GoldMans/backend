package com.goldmen.home.vo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Arrays;

@NoArgsConstructor
@ToString
@Getter
public class Position {

    @JsonProperty("x")
    private String longitude;

    @JsonProperty("y")
    private String latitude;

    @JsonProperty("address_name")
    private String address;

    public String getLegalName() {
        String[] array = address.split(" ");
        String ret = Arrays.stream(array).filter(str -> str.endsWith("동")).findFirst()
                .orElse(array[0]);
        return ret.substring(0, ret.length() - 1);
    }
}
