package com.goldmen.jpadomain.user.member.service;

import com.goldmen.jpadomain.user.member.domain.Member;

public interface MemberModifyService {
    Member save(Member member);

    void update(Member member, String newPassword);

    boolean delete(int id, String password);
}
