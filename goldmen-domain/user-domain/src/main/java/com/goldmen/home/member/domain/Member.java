package com.goldmen.home.member.domain;

import com.goldmen.home.agentuser.AgentUser;
import com.goldmen.home.member.domain.embedded.Email;
import com.goldmen.home.member.domain.embedded.Password;
import com.goldmen.home.member.domain.embedded.Phone;
import jakarta.persistence.*;
import lombok.*;

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
}
