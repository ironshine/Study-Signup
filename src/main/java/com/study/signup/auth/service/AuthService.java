package com.study.signup.auth.service;

import com.study.signup.auth.dto.SignupRequestDto;
import com.study.signup.auth.dto.SignupResponseDto;
import com.study.signup.config.PasswordEncoder;
import com.study.signup.user.entity.User;
import com.study.signup.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public SignupResponseDto signup(SignupRequestDto signupRequestDto) {
        if (userRepository.findByEmail(signupRequestDto.getEmail()) != null) {
            throw new IllegalArgumentException("이메일 중복! 다른 이메일로 회원가입하세요");
        }
        String password = passwordEncoder.encode(signupRequestDto.getPassword());

        User user = User.of(signupRequestDto.getName(), signupRequestDto.getEmail(), password);

        userRepository.save(user);
        return SignupResponseDto.of(user);
    }
}
