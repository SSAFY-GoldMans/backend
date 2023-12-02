package com.goldmen.redisdomain.building.building.fixture;

import com.goldmen.jpadomain.building.building.domain.Building;
import com.goldmen.jpadomain.map.legal.domain.Legal;
import com.goldmen.redisdomain.map.legal.fixture.LegalFixture;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum BuildingFixture {
    building1("강남빌딩","빌딩","1234","4312",2000,123.123457D,321.123455D),
    building2("강남빌딩","빌딩","4321","1234",2000,123.123457D,321.123455D);

    private String name;
    private String type;
    private String mainNumber;
    private String subNumber;
    private int constructionYear;
    private double lat;
    private double lng;

    public Building createBuilding(Legal legal){
        return Building.builder()
                .lng(lng)
                .lat(lat)
                .mainNumber(mainNumber)
                .subNumber(subNumber)
                .name(name)
                .type(type)
                .constructionYear(constructionYear)
                .legal(legal)
                .build();
    }

    public Building createBuilding(){
        return Building.builder()
                .lng(lng)
                .lat(lat)
                .mainNumber(mainNumber)
                .subNumber(subNumber)
                .name(name)
                .type(type)
                .constructionYear(constructionYear)
                .legal(LegalFixture.legal1.createLegal())
                .build();
    }
}
