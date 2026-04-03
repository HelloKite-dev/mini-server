package com.seoyeon.mini_server.user.service;

import org.springframework.stereotype.Service;

import com.seoyeon.mini_server.user.dao.UserDao;
import com.seoyeon.mini_server.user.dto.LoginRequestDto;
import com.seoyeon.mini_server.user.dto.LoginResponseDto;
import com.seoyeon.mini_server.user.dto.UserRequestDto;
import com.seoyeon.mini_server.user.dto.UserResponseDto;
import com.seoyeon.mini_server.util.JwtUtil;

import lombok.RequiredArgsConstructor;

import java.util.UUID;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Service
@RequiredArgsConstructor
public class UserService {
	private final UserDao userDao;
	private final BCryptPasswordEncoder passwordEncoder;
	private final JwtUtil jwtUtil;

	// 회원가입
	public int insertUser(UserRequestDto userRequestDto) {
		userRequestDto.setUserPw(passwordEncoder.encode(userRequestDto.getUserPw()));
		return userDao.insertUser(userRequestDto);
	}

	// 사용자 조회 (로그인 시)
	public UserResponseDto selectUser(String userId) {
		return userDao.selectUser(userId);
	}

	// 로그인
	public LoginResponseDto login(LoginRequestDto loginRequestDto) {
		UserRequestDto user = userDao.selectUserForLogin(loginRequestDto.getUserId());

		if (user == null) {
			throw new RuntimeException("존재하지 않는 아이디입니다.");
		}
		
		if (!passwordEncoder.matches(loginRequestDto.getUserPw(), user.getUserPw())) {
			throw new RuntimeException("비밀번호가 일치하지 않습니다.");
		}
		
		LoginResponseDto response = new LoginResponseDto();
		response.setToken(jwtUtil.generateToken(user.getUserId()));
		response.setUserId(user.getUserId());
		response.setUserNm(user.getUserNm());
		response.setNickname(user.getNickname());
		
		return response;
	}

	public UserResponseDto selectUserByNickname(String nickname) {
		return userDao.selectUserByNickname(nickname);
	}

	public UserResponseDto selectUserByUserEmail(String userEmail) {
		return userDao.selectUserByUserEmail(userEmail);
	}
	
	// 비밀번호 변경
	public int updateUserPw(UserRequestDto userRequestDto) {
		UserRequestDto user = userDao.selectUserForLogin(userRequestDto.getUserId());
		if(!passwordEncoder.matches(userRequestDto.getCurrentPw(), user.getUserPw())) {
			throw new RuntimeException("기존 비밀번호가 일치하지 않습니다.");
		}
		userRequestDto.setUserPw(passwordEncoder.encode(userRequestDto.getNewPw()));
		return userDao.updateUserPw(userRequestDto);
	}

	public String resetPassword (String userId, String userEmail) {
		boolean exists = userDao.existsUserByIdAndEmail(userId, userEmail);

		if (!exists) return null; // 사용자 없음
    
		String tempPw = UUID.randomUUID().toString().substring(0, 8);
		
		UserRequestDto dto = new UserRequestDto();
		dto.setUserId(userId);
		dto.setUserPw(passwordEncoder.encode(tempPw));
		
		userDao.updateUserPw(dto);
		return tempPw;
	}

	public int updateNickname(UserRequestDto userRequestDto) {
		return userDao.updateNickname(userRequestDto);
	}
}
