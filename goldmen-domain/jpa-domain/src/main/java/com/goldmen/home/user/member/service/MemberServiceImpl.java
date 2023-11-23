package com.goldmen.home.user.member.service;

import com.goldmen.home.user.member.domain.Member;
import com.goldmen.home.user.member.domain.MemberRepository;
import com.goldmen.home.user.member.domain.embedded.Email;
import com.goldmen.home.user.member.domain.embedded.Password;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

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

    @Override
    public Member findByEmail(Email email) {
        return memberRepository.findByEmail(email)
                .orElseThrow();
    }

    @Override
    public boolean update(int id, String currentPassword, String newPasswordStr) {
        Member member = memberRepository.findById(id).orElseThrow();
        if (member.getPassword().getValue().equals(currentPassword)) {
            member.updatePassword(Password.from(newPasswordStr));
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean delete(int id, String password) {
        Optional<Member> member = memberRepository.findById(id);
        if (member.isEmpty() || !member.get().getPassword().getValue().equals(password)) {
            return false;
        }
        memberRepository.deleteById(id);
        return true;
    }
}
