package com.goldmen.home.user.member.service;

import com.goldmen.home.user.member.dto.request.MemberSignupRequest;
import com.goldmen.home.user.member.fixture.MemberFixture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.Assertions.assertThatCode;

@Rollback
@SpringBootTest
class MemberServiceTest {
    @Autowired
    private MemberService memberService;

    @DisplayName("회원가입에 성공한다")
    @Test
    void signupSuccess() {
        /* Given */
        MemberSignupRequest request = MemberFixture.정욱.회원가입_요청을_생성한다();

        /* When */
        /* Then */
        assertThatCode(() -> memberService.signup(request))
                .doesNotThrowAnyException();
    }
}