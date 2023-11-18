package com.goldmen.home.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

import java.util.Arrays;

@ToString
@Getter
public class Position {

    private String longitude;
    private String latitude;
    private String address;

    public Position(@JsonProperty("x") String longitude, @JsonProperty("y") String latitude, @JsonProperty("address_name") String address) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.address = address;
    }

    public String getLegalName() {
        String[] array = address.split(" ");
        String ret = Arrays.stream(array).filter(str -> str.endsWith("동")).findFirst()
                .orElse(array[0]);
        return ret.substring(0, ret.length() - 1);
    }
}
