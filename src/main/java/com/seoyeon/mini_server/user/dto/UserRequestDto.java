package com.seoyeon.mini_server.user.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequestDto {
	private String userId;
	private String userPw;
	private String userNm;
	private String userEmail;
	private LocalDateTime regDt;
}
