package com.goldmen.home.agent.office;

import com.goldmen.home.map.legal.domain.Legal;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
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
}
