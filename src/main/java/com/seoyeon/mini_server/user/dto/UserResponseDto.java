package com.seoyeon.mini_server.user.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponseDto {
	private String userId;
	private String userNm;
	private String userEmail;
	private String nickname;
	private String gender;
	private LocalDate birth;
	private LocalDateTime regDt;
}
