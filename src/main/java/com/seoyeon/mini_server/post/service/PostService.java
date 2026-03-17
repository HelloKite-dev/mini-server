package com.seoyeon.mini_server.post.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.seoyeon.mini_server.post.dao.PostDao;
import com.seoyeon.mini_server.post.dto.PostDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostDao postDao;

    // 게시글 전체 조회
    public List<PostDto> selectAllPostList() {
        return postDao.selectAllPostList();
    }

    // 게시글 상세 조회
    public PostDto selectPostDetail(Long id) {
        return postDao.selectPostDetail(id);
    }
	
	// 게시글 작성
	public int insertPost(PostDto postDto) {
		return postDao.insertPost(postDto);
	}

    // 게시글 수정
    public int updatePost(PostDto postDto) {
        return postDao.updatePost(postDto);
    }

    // 게시글 삭제
    public int deletePost(Long id) {
        return postDao.deletePost(id);
    }
}
