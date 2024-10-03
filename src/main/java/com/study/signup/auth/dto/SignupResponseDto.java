package com.study.signup.auth.dto;

import com.study.signup.user.entity.User;
import lombok.Getter;

@Getter
public class SignupResponseDto {
    private final Long id;
    private final String name;
    private final String email;
    private final String password;


    public static SignupResponseDto of(User user) {
        return new SignupResponseDto(user);
    }

    private SignupResponseDto(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.password = user.getPassword();
    }
}
