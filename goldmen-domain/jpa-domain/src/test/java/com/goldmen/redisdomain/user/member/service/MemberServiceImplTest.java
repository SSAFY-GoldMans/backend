package com.goldmen.redisdomain.user.member.service;

import com.goldmen.jpadomain.user.member.domain.Member;
import com.goldmen.redisdomain.user.member.fixture.MemberFixture;
import com.goldmen.jpadomain.user.member.service.MemberServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.*;

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

    @DisplayName("이메일로 회원 찾기에 성공한다")
    @Test
    void findByEmailTestSuccess() {
        /* Given */
        memberService.save(MemberFixture.정욱.사용자를_생성한다());

        /* When */
        /* Then */
        assertThatCode(() -> memberService.findByEmail(MemberFixture.정욱.이메일을_가져온다()))
                .doesNotThrowAnyException();
    }

    @DisplayName("이메일로 회원 찾기에 실패한다")
    @Test
    void findByEmailFailureTestSuccess() {
        /* Given */
        /* When */
        /* Then */
        assertThatThrownBy(() -> memberService.findByEmail(MemberFixture.정욱.이메일을_가져온다()))
                .isInstanceOf(RuntimeException.class);
    }
}