package com.goldmen.home.user.member.domain;

import com.goldmen.home.user.member.fixture.MemberFixture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class MemberRepositoryTest {
    @Autowired
    private MemberRepository memberRepository;

    @DisplayName("회원 저장에 성공한다")
    @Test
    void saveSuccess() {
        /* Given */
        Member member = MemberFixture.정욱.사용자를_생성한다();

        /* When */
        Member saveMember = memberRepository.save(member);

        /* Then */
        assertThat(saveMember).isNotNull();
    }

    @DisplayName("이메일 조회에 성공한다")
    @Test
    void existedByEmailSuccess() {
        /* Given */
        Member member = memberRepository.save(MemberFixture.정욱.사용자를_생성한다());

        /* When */
        boolean actual = memberRepository.existsByEmail(member.getEmail());

        /* Then */
        assertThat(actual).isTrue();
    }
}