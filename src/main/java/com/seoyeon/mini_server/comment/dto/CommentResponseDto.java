package com.seoyeon.mini_server.comment.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentResponseDto {
	private Long id;
	private Long postId;
	private String userId;
	private String nickname;
	private String content;
	private LocalDateTime regDt;
    private LocalDateTime modDt;
}
