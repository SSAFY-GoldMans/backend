package com.goldmen.home.building.building.data.cond;

import com.goldmen.home.building.building.domain.Building;
import com.goldmen.home.map.legal.domain.Legal;
import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class FindBuildingOptionCond {
    private Legal legal;
    private double lat;
    private double lng;
    private int mainNumber;
    private int subNumber;
    private String buildingType;
    private String buildingName;

    public static FindBuildingOptionCond of(Building building){
        return FindBuildingOptionCond.builder()
                .legal(building.getLegal())
                .lat(building.getLat())
                .lng(building.getLng())
                .mainNumber(building.getMainNumber())
                .subNumber(building.getSubNumber())
                .buildingType(building.getType())
                .buildingName(building.getName())
                .build();
    }

    @Builder
    private FindBuildingOptionCond(Legal legal, double lat, double lng, int mainNumber, int subNumber, String buildingType, String buildingName) {
        this.legal = legal;
        this.lat = lat;
        this.lng = lng;
        this.mainNumber = mainNumber;
        this.subNumber = subNumber;
        this.buildingType = buildingType;
        this.buildingName = buildingName;
    }
}
