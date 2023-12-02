package com.goldmen.redisdomain.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@ToString
@Getter
public class Position {

    @JsonProperty("x")
    private Double longitude;

    @JsonProperty("y")
    private Double latitude;

    @JsonProperty("address_name")
    private String address;

    public String getLegalName() {
        return address.split(" ")[2];
    }

    public String getDistrictName() {
        return address.split(" ")[1];
    }

    public boolean inSeoul() {
        return address.startsWith("서울");
    }
}
