package com.goldmen.home.user.member.service;

import com.goldmen.home.type.ApiResponse;
import com.goldmen.home.user.member.domain.Member;
import com.goldmen.home.user.member.domain.embedded.Email;
import com.goldmen.home.user.member.dto.request.MemberLoginRequest;
import com.goldmen.home.user.member.dto.request.MemberSignupRequest;
import com.goldmen.home.user.member.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.goldmen.home.user.message.MemberMessage.SUCCESS_LOGIN;
import static com.goldmen.home.user.message.MemberMessage.SUCCESS_SIGNUP;

@RequiredArgsConstructor
@Service
public class MemberService {
    private final MemberModifyService memberSaveService;
    private final MemberLoadService memberLoadService;

    private final MemberMapper mapper;

    public ApiResponse<String> signup(MemberSignupRequest request) {
        Member member = mapper.toJpaEntity(request);
        memberSaveService.save(member);

        return ApiResponse.noContent()
                .addMessage(SUCCESS_SIGNUP);
    }

    public ApiResponse<Integer> login(MemberLoginRequest request) {
        Member findMember = memberLoadService.findByEmail(Email.from(request.email()));

        return ApiResponse.valueOf(findMember.getId())
                .addMessage(SUCCESS_LOGIN);
    }
}
