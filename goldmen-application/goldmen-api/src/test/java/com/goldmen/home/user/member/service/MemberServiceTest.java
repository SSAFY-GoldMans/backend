package com.goldmen.home.user.member.service;

import com.goldmen.home.type.ApiResponse;
import com.goldmen.home.user.member.dto.request.MemberSignupRequest;
import com.goldmen.home.user.member.fixture.MemberFixture;
import com.goldmen.home.user.message.MemberMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.Assertions.assertThat;
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

    @DisplayName("로그인에 성공한다")
    @Test
    void loginTestSuccess() {
        /* Given */
        memberService.signup(MemberFixture.정욱.회원가입_요청을_생성한다());

        /* When */
        ApiResponse<Integer> response = memberService.login(MemberFixture.정욱.로그인_요청을_생성한다());

        /* Then */
        assertThat(response.getMessages().get(0)).isEqualTo(MemberMessage.SUCCESS_LOGIN.getMessage());
    }
}