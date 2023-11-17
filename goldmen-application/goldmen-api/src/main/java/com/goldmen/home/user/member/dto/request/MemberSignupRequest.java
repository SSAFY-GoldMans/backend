package com.goldmen.home.user.member.dto.request;

import com.goldmen.home.user.member.domain.Role;

public record MemberSignupRequest(String email,
                                  String password,
                                  String validatePassword,
                                  String phone,
                                  Role role) {
}
