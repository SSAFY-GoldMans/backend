package com.goldmen.jpadomain.map.district.domain;

import com.goldmen.jpadomain.map.legal.domain.Legal;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class District {
    @Id
    @Column(name = "district_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Size(max = 10)
    @NotBlank
    @Column(name = "district_name", nullable = false, length = 10)
    private String name;

    @Size(max = 10)
    @NotBlank
    @Column(name = "district_code", unique = true, nullable = false, length = 10)
    private String code;

    @OneToMany(mappedBy = "district")
    private List<Legal> legals = new ArrayList<>();

    @Builder
    public District(String name, String code) {
        this.name = name;
        this.code = code;
    }
}
