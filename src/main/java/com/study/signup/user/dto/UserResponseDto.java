package com.study.signup.user.dto;

import com.study.signup.user.entity.User;
import lombok.Getter;

@Getter
public class UserResponseDto {
    private final Long Id;
    private final String name;
    private final String email;
    private final String password;

    public static UserResponseDto of(User user) {
        return new UserResponseDto(user);
    }

    private UserResponseDto(User user) {
        this.Id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.password = user.getPassword();
    }
}
