package com.goldmen.home.building.building.domain;

import com.goldmen.home.map.legal.domain.Legal;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
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
    private String mainNumber;

    @Column(nullable = false)
    private String subNumber;

    @Column(nullable = false)
    private int constructionYear;

    @Column(nullable = false)
    private double lat;

    @Column(nullable = false)
    private double lng;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "legal_id")
    private Legal legal;

    @Builder
    public Building(String name,
                    String type,
                    String mainNumber,
                    String subNumber,
                    int constructionYear,
                    double lat,
                    double lng,
                    Legal legal) {
        this.name = name;
        this.type = type;
        this.mainNumber = mainNumber;
        this.subNumber = subNumber;
        this.constructionYear = constructionYear;
        this.lat = lat;
        this.lng = lng;
        this.legal = legal;
    }
}
