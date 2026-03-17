package com.seoyeon.mini_server.post.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.seoyeon.mini_server.post.dto.PostDto;
import com.seoyeon.mini_server.post.service.PostService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    // 게시글 전체 조회
    @GetMapping
    public List<PostDto> selectAllPostList() {
        return postService.selectAllPostList();
    }

    // 게시글 상세 조회
    @GetMapping("/{id}")
    public PostDto selectPostDetail(@PathVariable Long id) {
        return postService.selectPostDetail(id);
    }

	// 게시글 작성
	@PostMapping
	public int insertPost(@RequestBody PostDto postDto) {
		return postService.insertPost(postDto);
	}

    // 게시글 수정
	@PutMapping("/{id}")
	public int updatePost(@PathVariable Long id, @RequestBody PostDto postDto) {
        postDto.setId(id);
		return postService.updatePost(postDto);
	}

    // 게시글 삭제
    @DeleteMapping("/{id}")
    public int deletePost(@PathVariable Long id) {
        return postService.deletePost(id);
    }
}