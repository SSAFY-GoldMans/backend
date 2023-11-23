package com.goldmen.home.user.member.service;

import com.goldmen.home.user.member.domain.Member;

public interface MemberModifyService {
    Member save(Member member);

    boolean update(int id, String currentPassword, String newPasswordStr);

    boolean delete(int id, String password);
}
