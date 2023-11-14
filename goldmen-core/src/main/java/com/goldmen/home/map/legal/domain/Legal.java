package com.goldmen.home.map.legal.domain;

import com.goldmen.home.agentoffice.office.domain.Office;
import com.goldmen.home.house.building.domain.Building;
import com.goldmen.home.map.district.domain.District;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Getter
@Entity
public class Legal {
    @Id
    @Column(name = "legal_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Max(10)
    @Column(name = "legal_name", nullable = false, length = 10)
    private String name;

    @Max(10)
    @Column(name = "legal_code", nullable = false, length = 10)
    private String code;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "district_id")
    private District district;

    @OneToMany(mappedBy = "legal")
    private List<Office> officeList = new ArrayList<>();

    @OneToMany(mappedBy = "legal")
    private List<Building> buildingList = new ArrayList<>();
}