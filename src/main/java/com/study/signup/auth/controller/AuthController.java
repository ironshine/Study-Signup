package com.study.signup.auth.controller;

import com.study.signup.auth.dto.SignupRequestDto;
import com.study.signup.auth.dto.SignupResponseDto;
import com.study.signup.auth.service.AuthService;
import com.study.signup.kakao.service.KakaoService;
import com.study.signup.user.service.UserService;
import jakarta.servlet.http.Cookie;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;
    private final KakaoService kakaoService;

    @PostMapping("/signup")
    public ResponseEntity<SignupResponseDto> signup(
            @RequestBody @Valid SignupRequestDto signupRequestDto
    ) {
        return ResponseEntity.status(HttpStatus.CREATED).body(authService.signup(signupRequestDto));
    }

    @PostMapping("/oauth")
    public ResponseEntity<String> signup(
            @RequestParam String code
    ) {
        String token = kakaoService.kakaoLogin(code);

        return ResponseEntity.status(HttpStatus.CREATED).body("abs");
    }
}
