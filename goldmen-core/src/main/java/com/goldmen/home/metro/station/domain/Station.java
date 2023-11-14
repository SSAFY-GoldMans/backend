package com.goldmen.home.metro.station.domain;

import com.goldmen.home.global.domain.Coord;
import com.goldmen.home.metro.line.domain.Line;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Getter
@Entity
public class Station {
    @Id
    @Column(name = "station_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "station_name", nullable = false, length = 10)
    private String name;

    @Column(name = "station_code", nullable = false)
    private int code;

    @Embedded
    private Coord coord;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "line_id")
    private Line line;
}
