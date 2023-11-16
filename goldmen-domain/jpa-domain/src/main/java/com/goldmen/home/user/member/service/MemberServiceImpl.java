package com.goldmen.home.user.member.service;

import com.goldmen.home.user.member.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class MemberServiceImpl
        implements MemberModifyService, MemberLoadService {
    @Override
    public boolean existsByEmail(String email) {
        return false;
    }

    @Transactional
    @Override
    public Member save(Member member) {
        return null;
    }
}
