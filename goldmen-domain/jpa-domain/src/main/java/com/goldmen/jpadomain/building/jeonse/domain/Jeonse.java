package com.goldmen.jpadomain.building.jeonse.domain;


import com.goldmen.jpadomain.building.building.domain.Building;
import com.goldmen.jpadomain.building.global.domain.HouseInfo;
import com.goldmen.jpadomain.building.global.domain.Saleable;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Jeonse implements Saleable {
    @Id
    @Column(name = "jeonse_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Embedded
    private HouseInfo houseInfo;

    private int price; //단위: 만원

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "building_id")
    private Building building;

    @Builder
    public Jeonse(HouseInfo houseInfo, int price, Building building) {
        this.houseInfo = houseInfo;
        this.price = price;
        this.building = building;
    }

    public int getFloor() {
        return houseInfo.getFloor();
    }

    public double getArea() {
        return houseInfo.getArea();
    }
}
