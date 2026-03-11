package com.seoyeon.mini_server.post.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.seoyeon.mini_server.post.dto.PostDto;

@Mapper
public interface PostDao {
	// 게시글 전체 조회
	List<PostDto> selectAllPostList();

	// 게시글 상세 조회
	PostDto selectPostDetail(Long id);
	
	// 게시글 작성
	int insertPost(PostDto postDto);
} 
