package com.seoyeon.mini_server.post.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostDto {
	private Long id;
    private String userId;
    private String title;
    private String content;
    private int viewCount;
    private LocalDateTime regDt;
    private LocalDateTime modDt;
}
