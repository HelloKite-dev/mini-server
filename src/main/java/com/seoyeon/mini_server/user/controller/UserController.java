package com.seoyeon.mini_server.user.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.seoyeon.mini_server.post.dto.PostDto;
import com.seoyeon.mini_server.user.dto.LoginRequestDto;
import com.seoyeon.mini_server.user.dto.LoginResponseDto;
import com.seoyeon.mini_server.user.dto.UserRequestDto;
import com.seoyeon.mini_server.user.dto.UserResponseDto;
import com.seoyeon.mini_server.user.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
	private final UserService userService;

	// 회원가입
	@PostMapping
	public int insertUser(@RequestBody UserRequestDto userRequestDto) {
		return userService.insertUser(userRequestDto);
	}

	// 사용자 조회(로그인 시)
	@GetMapping("/{userId}")
	public UserResponseDto selectUser(@PathVariable String userId) {
		return userService.selectUser(userId);
	}

	@PostMapping("/login")
	public LoginResponseDto login(@RequestBody LoginRequestDto loginRequestDto) {
		return userService.login(loginRequestDto);
	}

	// 아이디 중복체크
	@GetMapping("/check/{userId}")
	public boolean checkUserId(@PathVariable String userId) {
		return userService.selectUser(userId) != null;
	}

	// 닉네임 중복체크
	@GetMapping("/check/nickname/{nickname}")
	public boolean checkNickname(@PathVariable String nickname) {
		return userService.selectUserByNickname(nickname) != null;
	}

	// 이메일 중복 체크
	@GetMapping("/check/email/{userEmail}")
	public boolean checkUserEmail(@PathVariable String userEmail) {
		return userService.selectUserByUserEmail(userEmail) != null;
	}

	// 비밀번호 변경
	@PutMapping("/password")
	public int updateUserPw(@RequestBody UserRequestDto userRequestDto) {
		return userService.updateUserPw(userRequestDto);
	}

	// 비밀번호 초기화
	@PutMapping("/reset-password")
	public String resetPassword(@RequestBody UserRequestDto dto) {
		return userService.resetPassword(dto.getUserId(), dto.getUserEmail());
		// 사용자 없으면 null, 있으면 tempPw 문자열 반환
	}
}
