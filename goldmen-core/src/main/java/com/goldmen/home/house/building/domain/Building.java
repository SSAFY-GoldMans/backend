package com.goldmen.home.house.building.domain;

import com.goldmen.home.global.domain.Coord;
import com.goldmen.home.map.legal.domain.Legal;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Getter
@Entity
public class Building {
    @Id
    @Column(name = "building_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "building_name", nullable = false, length = 50)
    private String name;

    @Column(name = "building_type", nullable = false, length = 15)
    private String type;

    @Column(nullable = false)
    private int mainNumber;

    @Column(nullable = false)
    private int subNumber;

    @Column(nullable = false)
    private int constructionYear;

    @Embedded
    private Coord coord;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "legal_id")
    private Legal legal;
}
