package com.goldmen.jpadomain.user.member.service;

import com.goldmen.jpadomain.global.exception.JpaDomainException;
import com.goldmen.jpadomain.user.member.domain.Member;
import com.goldmen.jpadomain.user.member.domain.MemberRepository;
import com.goldmen.jpadomain.user.member.domain.embedded.Email;
import com.goldmen.jpadomain.user.member.domain.embedded.Password;
import com.goldmen.jpadomain.user.member.exception.MemberErrorCode;
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
            throw new JpaDomainException(MemberErrorCode.DUPLICATE_EMAIL);
        }
    }

    @Override
    public Member findByEmail(Email email) {
        return memberRepository.findByEmail(email)
                .orElseThrow();
    }

    @Transactional
    @Override
    public void update(Member member, String newPassword) {
        member.updatePassword(Password.from(newPassword));
    }

    @Override
    public boolean delete(int id, String password) {
        Optional<Member> member = memberRepository.findById(id);
        if (member.isEmpty() || !member.get().getPassword().equals(password)) {
            return false;
        }
        memberRepository.deleteById(id);
        return true;
    }

    @Override
    public Member findById(int id) {
        return memberRepository.findById(id)
                .orElseThrow(RuntimeException::new);
    }
}
