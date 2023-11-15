package com.goldmen.home.user.member.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MemberServiceTest {
    @Autowired
    private MemberService memberService;

    @DisplayName("회원 저장에 성공한다.")
    @Test
    void memberSaveSuccess() {
        /* Given */

        /* When */

        /* Then */
        System.out.println("1");
    }
}