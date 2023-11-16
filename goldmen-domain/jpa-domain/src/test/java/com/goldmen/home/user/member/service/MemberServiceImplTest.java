package com.goldmen.home.user.member.service;

import com.goldmen.home.user.member.domain.Member;
import com.goldmen.home.user.member.fixture.MemberFixture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@Transactional
@SpringBootTest
class MemberServiceImplTest {

    @Autowired
    private MemberServiceImpl memberService;

    @DisplayName("회원 저장에 성공한다")
    @Test
    void saveTestSuccess() {
        /* Given */
        Member member = MemberFixture.정욱.사용자를_생성한다();

        /* When */
        Member saveMember = memberService.save(member);

        /* Then */
        assertThat(saveMember).isNotNull();
    }

    @DisplayName("이메일 중복 검사에 성공한다")
    @Test
    void validateDuplicateByEmailTestSuccess() {
        /* Given */
        Member member = MemberFixture.정욱.사용자를_생성한다();
        memberService.save(member);

        /* When */
        /* Then */
        assertThatThrownBy(() -> memberService.save(member))
                .isInstanceOf(RuntimeException.class);
    }
}