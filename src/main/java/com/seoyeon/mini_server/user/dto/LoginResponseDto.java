package com.seoyeon.mini_server.user.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginResponseDto {
    private String token;
    private String userId;
    private String userNm;
    private String nickname;
}