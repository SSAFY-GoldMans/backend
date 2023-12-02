package com.goldmen.api.user.member.dto.request;

import com.goldmen.jpadomain.user.member.domain.Role;

public record MemberSignupRequest(String email,
                                  String password,
                                  String validatePassword,
                                  String phone,
                                  Role role) {
}
