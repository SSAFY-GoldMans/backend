package com.goldmen.home.user.member.controller;

import com.goldmen.home.type.ApiResponse;
import com.goldmen.home.user.member.dto.request.MemberDeleteRequest;
import com.goldmen.home.user.member.dto.request.MemberLoginRequest;
import com.goldmen.home.user.member.dto.request.MemberSignupRequest;
import com.goldmen.home.user.member.dto.request.MemberUpdateRequest;
import com.goldmen.home.user.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/member")
@RequiredArgsConstructor
@RestController
public class MemberController {
    private final MemberService memberService;

    @PostMapping("/signup")
    public ResponseEntity<ApiResponse<String>> signup(@RequestBody MemberSignupRequest request) {
        ApiResponse<String> response = memberService.signup(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponse<Integer>> login(@RequestBody MemberLoginRequest request) {
        ApiResponse<Integer> response = memberService.login(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/update")
    public ResponseEntity<ApiResponse<Boolean>> update(@RequestBody MemberUpdateRequest request) {
        ApiResponse<Boolean> response = memberService.update(request);
        if (response.getBody()) {
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.badRequest().body(response);
        }
    }

    @PostMapping("/delete")
    public ResponseEntity<ApiResponse<Boolean>> delete(@RequestBody MemberDeleteRequest request) {
        ApiResponse<Boolean> response = memberService.delete(request);
        if (response.getBody()) {
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.badRequest().body(response);
        }
    }
}
