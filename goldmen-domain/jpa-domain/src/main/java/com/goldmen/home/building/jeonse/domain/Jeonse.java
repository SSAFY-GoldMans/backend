package com.goldmen.home.building.jeonse.domain;


import com.goldmen.home.building.building.domain.Building;
import com.goldmen.home.building.global.domain.HouseInfo;
import com.goldmen.home.building.global.domain.Saleable;
import com.goldmen.home.map.district.domain.District;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
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

    @Override
    public int getFloor() {
        return houseInfo.getFloor();
    }

    @Override
    public double getArea() {
        return houseInfo.getArea();
    }
}
