package com.goldmen.home.user.member.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public record MemberDeleteRequest(
        @JsonProperty("id") int id,
        @JsonProperty("password") String password
) {
}
