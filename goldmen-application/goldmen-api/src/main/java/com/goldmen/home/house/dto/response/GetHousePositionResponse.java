package com.goldmen.home.house.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.goldmen.home.building.global.domain.Saleable;

import java.util.List;

public record GetHousePositionResponse(
        @JsonProperty("buildings")
        List<GetHousePosition> housePositionList
) {
    public static GetHousePositionResponse from(List<Saleable> saleableList) {
        return new GetHousePositionResponse(
                saleableList.stream().map(GetHousePosition::saleableToGetHouseResponse).toList()
        );
    }
}
