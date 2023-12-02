package com.goldmen.jpadomain.agent.office;

import com.goldmen.jpadomain.map.legal.domain.Legal;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Office {
    @Id
    @Column(name = "office_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "office_address", nullable = false, length = 100)
    private String address;

    @Column(name = "office_code", nullable = false)
    private String code;

    @Column(nullable = false, length = 20)
    private String businessName;

    @Column(name = "office_name", nullable = false, length = 30)
    private String name;

    @Column(name = "office_phone", length = 100)
    private String phone;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "legal_id")
    private Legal legal;

    @Builder
    public Office(String address,
                  String code,
                  String businessName,
                  String name,
                  String phone,
                  Legal legal) {
        this.address = address;
        this.code = code;
        this.businessName = businessName;
        this.name = name;
        this.phone = phone;
        this.legal = legal;
    }
}
