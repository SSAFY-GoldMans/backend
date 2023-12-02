package com.goldmen.jpadomain.agent.evaluation.domain;

import com.goldmen.jpadomain.user.member.domain.Member;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Evaluation {
    @Id
    @Column(name = "evaluation_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 100)
    private String content;

    @Column(nullable = false)
    private int rate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @Builder
    public Evaluation(String content, int rate, Member member) {
        this.content = content;
        this.rate = rate;
        this.member = member;
    }
}
