package com.seoyeon.mini_server.user.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
