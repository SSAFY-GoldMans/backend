package com.goldmen.jpadomain.user.member.service;

import com.goldmen.jpadomain.user.member.domain.Member;
import com.goldmen.jpadomain.user.member.domain.embedded.Email;

public interface MemberLoadService {
    Member findByEmail(Email email);

    Member findById(int id);
}
