package com.seoyeon.mini_server.user.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.seoyeon.mini_server.user.dto.UserRequestDto;
import com.seoyeon.mini_server.user.dto.UserResponseDto;

@Mapper
public interface UserDao {
	// 회원가입
	int insertUser(UserRequestDto userRequestDto);

	// 사용자 조회 (로그인 시)
	UserResponseDto selectUser(String userId);

	// 비밀번호 가져오기
	UserRequestDto selectUserForLogin(@Param("userId") String userId);
}
