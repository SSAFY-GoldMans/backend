package com.goldmen.home.user.member.service;

import com.goldmen.home.user.member.domain.Member;
import com.goldmen.home.user.member.domain.MemberRepository;
import com.goldmen.home.user.member.domain.embedded.Email;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class MemberServiceImpl
        implements MemberLoadService, MemberModifyService {
    private final MemberRepository memberRepository;

    @Transactional
    @Override
    public Member save(Member member) {
        validateDuplicateBy(member.getEmail());

        return memberRepository.save(member);
    }

    private void validateDuplicateBy(Email email) {
        if (memberRepository.existsByEmail(email)) {
            throw new RuntimeException();
        }
    }
}
