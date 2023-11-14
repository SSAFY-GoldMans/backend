package com.goldmen.home.user.member.domain;

import com.goldmen.home.agentoffice.comment.domain.Evaluation;
import com.goldmen.home.house.wishlist.domain.Wishlist;
import com.goldmen.home.user.agentuser.AgentUser;
import com.goldmen.home.user.member.domain.embedded.Email;
import com.goldmen.home.user.member.domain.embedded.Password;
import com.goldmen.home.user.member.domain.embedded.Phone;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Getter
@Entity
public class Member {
    @Id
    @Column(name = "member_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Embedded
    private Email email;

    @Embedded
    private Password password;

    @Embedded
    private Phone phone;

    @Column(nullable = false, length = 10)
    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToOne(mappedBy = "member")
    private AgentUser agentUser;

    @OneToMany(mappedBy = "member")
    private List<Evaluation> evaluations = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<Wishlist> wishlists = new ArrayList<>();
}
