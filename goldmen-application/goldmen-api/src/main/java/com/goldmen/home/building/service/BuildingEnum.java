package com.goldmen.home.building.service;

public enum BuildingEnum {
    APT("아파트"), OFFICETEL("오피스텔");

    public final String strKorean;

    BuildingEnum(String korean) {
        this.strKorean = korean;
    }
}
