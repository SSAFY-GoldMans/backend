package com.goldmen.home.building.monthly.domain;

import com.goldmen.home.building.building.domain.Building;
import com.goldmen.home.building.global.domain.HouseInfo;
import com.goldmen.home.building.global.domain.Saleable;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Monthly implements Saleable {
    @Id
    @Column(name = "monthly_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Embedded
    private HouseInfo houseInfo;

    @Column(nullable = false)
    private int price;  //만원

    @Column(nullable = false)
    private int rent;   //만원

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "building_id")
    private Building building;

    @Builder
    public Monthly(HouseInfo houseInfo, int price, int rent) {
        this.houseInfo = houseInfo;
        this.price = price;
        this.rent = rent;
    }

    @Override
    public double getArea() {
        return houseInfo.getArea();
    }

    @Override
    public int getFloor() {
        return houseInfo.getFloor();
    }
}
