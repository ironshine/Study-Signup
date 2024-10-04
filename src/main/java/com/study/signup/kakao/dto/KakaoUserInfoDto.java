package com.study.signup.kakao.dto;

import com.study.signup.user.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class KakaoUserInfoDto {
    private Long id;
    private String nickname;
    private String email;


//    public static KakaoUserInfoDto of(User user) {
//        return new KakaoUserInfoDto(user.getId(), user.getName(), user.getEmail());
//    }
    public KakaoUserInfoDto(Long id, String nickname, String email) {
        this.id = id;
        this.nickname = nickname;
        this.email = email;
    }
}