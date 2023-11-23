package com.goldmen.home.user.member.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public record MemberUpdateRequest(
        @JsonProperty("id") int id,
        @JsonProperty("currentPassword") String currentPassword,
        @JsonProperty("newPassword") String newPassword,
        @JsonProperty("validateNewPassword") String validateNewPassword
) {
}
