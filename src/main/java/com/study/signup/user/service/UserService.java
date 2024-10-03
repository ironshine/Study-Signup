package com.study.signup.user.service;

import com.study.signup.user.dto.UserResponseDto;
import com.study.signup.user.entity.User;
import com.study.signup.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<UserResponseDto> getUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map(UserResponseDto::of).toList();
    }
}
