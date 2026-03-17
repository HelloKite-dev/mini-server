package com.seoyeon.mini_server.comment.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.seoyeon.mini_server.comment.dto.CommentRequestDto;
import com.seoyeon.mini_server.comment.dto.CommentResponseDto;

@Mapper
public interface CommentDao {
	// 댓글 조회
	List<CommentResponseDto> selectCommentList(Long postId);
	
	// 댓글 작성
	int insertComment(CommentRequestDto commentRequestDto);

	// 댓글 수정
	int updateComment(CommentRequestDto commentRequestDto);

	// 댓글 삭제
	int deleteComment(Long id);
}
