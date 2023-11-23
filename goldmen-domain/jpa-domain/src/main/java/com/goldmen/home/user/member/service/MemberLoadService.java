package com.goldmen.home.user.member.service;

import com.goldmen.home.user.member.domain.Member;
import com.goldmen.home.user.member.domain.embedded.Email;

public interface MemberLoadService {
    Member findByEmail(Email email);

    Member findById(int id);
}
