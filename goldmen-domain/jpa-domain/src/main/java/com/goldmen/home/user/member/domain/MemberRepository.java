package com.goldmen.home.user.member.domain;

import com.goldmen.home.user.member.domain.embedded.Email;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Integer> {
    boolean existsByEmail(Email email);
}
