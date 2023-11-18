package com.goldmen.home.building.building.fixture;

import com.goldmen.home.building.building.domain.Building;
import com.goldmen.home.map.legal.domain.Legal;
import com.goldmen.home.map.legal.fixture.LegalFixture;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum BuildingFixture {
    building1("강남빌딩","빌딩",1234,4321,2000,123.123457D,321.123455D),
    building2("강남빌딩","빌딩",4321,1234,2000,123.123457D,321.123455D);

    private String name;
    private String type;
    private int mainNumber;
    private int subNumber;
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
