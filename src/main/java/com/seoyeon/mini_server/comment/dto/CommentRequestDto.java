package com.seoyeon.mini_server.comment.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentRequestDto {
	private Long Id;
	private Long postId;
	private String userId;
	private String content;
}
