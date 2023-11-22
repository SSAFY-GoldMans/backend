package com.goldmen.home.building.Monthly.domain;

import com.goldmen.home.building.building.domain.Building;
import com.goldmen.home.building.global.domain.HouseInfo;
import com.goldmen.home.building.global.domain.Saleable;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
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

    @Override
    public double getArea() {
        return houseInfo.getArea();
    }

    @Override
    public int getFloor() {
        return houseInfo.getFloor();
    }
}
