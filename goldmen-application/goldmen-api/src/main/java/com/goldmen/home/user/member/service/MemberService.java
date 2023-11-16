package com.goldmen.home.user.member.service;

import com.goldmen.home.user.member.domain.Member;
import com.goldmen.home.user.member.domain.embedded.Email;
import com.goldmen.home.user.member.dto.request.MemberSignupRequest;
import com.goldmen.home.user.member.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MemberService {
    private final MemberModifyService memberSaveService;
    private final MemberLoadService memberLoadService;

    private final MemberMapper mapper;

    public void signup(MemberSignupRequest request) {
        Member member = mapper.toJpaEntity(request);
        validateDuplicateSignupByEmail(member.getEmail());

        memberSaveService.save(member);
    }

    private void validateDuplicateSignupByEmail(Email email) {
        if (memberLoadService.existsByEmail(email)) {
            throw new RuntimeException();
        }
    }
}
