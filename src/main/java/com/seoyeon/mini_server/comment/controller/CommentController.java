package com.seoyeon.mini_server.comment.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.seoyeon.mini_server.comment.dto.CommentRequestDto;
import com.seoyeon.mini_server.comment.dto.CommentResponseDto;
import com.seoyeon.mini_server.comment.service.CommentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/comments")
@RequiredArgsConstructor
public class CommentController {

	private final CommentService commentService;

	// 게시글 별 댓글 조회
	@GetMapping("/{postId}")
	public List<CommentResponseDto> selectCommentList(@PathVariable Long postId) {
		return commentService.selectCommentList(postId);
	}

	// 댓글 작성
	@PostMapping
	public int insertComment(@RequestBody CommentRequestDto commentRequestDto) {
		return commentService.insertComment(commentRequestDto);
	}

	// 댓글 수정
	@PutMapping("/{id}")
	public int updateComment(@PathVariable Long id, @RequestBody CommentRequestDto commentRequestDto) {
		commentRequestDto.setId(id);
		return commentService.updateComment(commentRequestDto);
	}

	// 댓글 삭제
	@DeleteMapping("/{id}")
	public int deleteComment(@PathVariable Long id) {
		return commentService.deleteComment(id);
	}
}
