package com.goldmen.home.legal.domain;

import com.goldmen.home.district.domain.District;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import lombok.*;

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
}