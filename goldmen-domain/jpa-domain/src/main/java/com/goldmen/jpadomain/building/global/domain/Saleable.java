package com.goldmen.jpadomain.building.global.domain;

import com.goldmen.jpadomain.building.building.domain.Building;

public interface Saleable {
    int getId();

    Building getBuilding();

    double getArea();

    int getPrice();

    int getFloor();
}
