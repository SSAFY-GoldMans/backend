package com.goldmen.home.building.wishlist.domain;

import com.goldmen.home.building.Monthly.domain.Monthly;
import com.goldmen.home.building.jeonse.domain.Jeonse;
import com.goldmen.home.building.trade.Trade;
import com.goldmen.home.user.member.domain.Member;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Getter
@Entity
public class Wishlist {
    @Id
    @Column(name = "wishlist_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "trade_id", nullable = false)
    private Trade trade;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "jeonse_id")
    private Jeonse jeonse;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "monthly_id")
    private Monthly monthly;
}
