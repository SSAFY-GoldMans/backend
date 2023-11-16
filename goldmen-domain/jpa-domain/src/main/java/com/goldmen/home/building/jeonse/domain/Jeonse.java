package com.goldmen.home.building.jeonse.domain;


import com.goldmen.home.building.global.domain.HouseInfo;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Getter
@Entity
public class Jeonse {
    @Id
    @Column(name = "jeonse_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Embedded
    private HouseInfo houseInfo;

    private int price;
}
