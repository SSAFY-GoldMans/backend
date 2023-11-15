package com.goldmen.home.Monthly.domain;

import com.goldmen.home.global.domain.HouseInfo;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Getter
@Entity
public class Monthly {
    @Id
    @Column(name = "monthly_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Embedded
    private HouseInfo houseInfo;

    @Column(nullable = false)
    private int price;

    @Column(nullable = false)
    private int rent;
}
