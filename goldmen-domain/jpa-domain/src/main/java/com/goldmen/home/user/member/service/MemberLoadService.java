package com.goldmen.home.user.member.service;

import com.goldmen.home.user.member.domain.embedded.Email;

public interface MemberLoadService {
    boolean existsByEmail(Email email);
}
