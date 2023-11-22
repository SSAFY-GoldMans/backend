package com.goldmen.home.building.global.domain;

import com.goldmen.home.building.building.domain.Building;

public interface Saleable {
    int getId();

    Building getBuilding();

    double getArea();

    int getPrice();

    int getFloor();
}
