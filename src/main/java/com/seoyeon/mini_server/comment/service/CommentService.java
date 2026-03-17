package com.seoyeon.mini_server.comment.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.seoyeon.mini_server.comment.dao.CommentDao;
import com.seoyeon.mini_server.comment.dto.CommentRequestDto;
import com.seoyeon.mini_server.comment.dto.CommentResponseDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommentService {
	private final CommentDao commentDao;

	// 게시글 별 댓글 조회
	public List<CommentResponseDto> selectCommentList(Long postId) {
		return commentDao.selectCommentList(postId);
	}

	// 댓글 작성
	public int insertComment(CommentRequestDto commentRequestDto) {
		return commentDao.insertComment(commentRequestDto);
	}

	// 댓글 수정
	public int updateComment(CommentRequestDto commentRequestDto) {
		return commentDao.updateComment(commentRequestDto);
	}

	// 댓글 삭제
	public int deleteComment(Long id) {
		return commentDao.deleteComment(id);
	}
}
