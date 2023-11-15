package com.goldmen.home.user.member.service;

import com.goldmen.home.member.domain.Member;
import com.goldmen.home.member.domain.MemberRepository;
import com.goldmen.home.member.domain.embedded.Email;
import com.goldmen.home.member.service.MemberLoadService;
import com.goldmen.home.member.service.MemberSaveService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class MemberService implements MemberLoadService, MemberSaveService {
    private final MemberRepository memberRepository;

    @Transactional
    @Override
    public Member save(Member member) {
        return memberRepository.save(member);
    }

    @Override
    public boolean existsByEmail(String email) {
        return memberRepository.existsByEmail(Email.from(email));
    }
}
