package com.goldmen.redisdomain.user.member.domain;

import com.goldmen.redisdomain.user.member.fixture.MemberFixture;
import com.goldmen.jpadomain.user.member.domain.Member;
import com.goldmen.jpadomain.user.member.domain.MemberRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

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

    @DisplayName("이메일로 회원 찾기에 성공한다.")
    @Test
    void findByEmailSuccess() {
        /* Given */
        Member member = memberRepository.save(MemberFixture.정욱.사용자를_생성한다());

        /* When */
        Optional<Member> findMember = memberRepository.findByEmail(member.getEmail());

        /* Then */
        assertThat(findMember).isPresent();
    }
}