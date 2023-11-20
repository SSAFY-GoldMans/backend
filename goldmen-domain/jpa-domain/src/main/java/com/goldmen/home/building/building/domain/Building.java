package com.goldmen.home.building.building.domain;

import com.goldmen.home.map.legal.domain.Legal;
import jakarta.persistence.*;
import lombok.*;

@ToString
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
}
