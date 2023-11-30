package com.goldmen.home.map.legal.domain;

import com.goldmen.home.map.district.domain.District;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "districtIdAndLegalCode",
                        columnNames = {"legal_code", "district_id"}
                )
        }
)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Legal {
    @Id
    @Column(name = "legal_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Size(max = 10)
    @Column(name = "legal_name", nullable = false, length = 10)
    private String name;

    @Size(max = 10)
    @Column(name = "legal_code", nullable = false, length = 10)
    private String code;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "district_id")
    private District district;

    @Builder
    public Legal(String name, String code) {
        this.name = name;
        this.code = code;
    }
}