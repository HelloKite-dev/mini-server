package com.seoyeon.mini_server.file.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.seoyeon.mini_server.file.dto.FileRequestDto;
import com.seoyeon.mini_server.file.dto.FileResponseDto;

@Mapper
public interface FileDao {
    
    int insertFile(FileRequestDto fileRequestDto);

    // 게시글 파일 목록 조회
    List<FileResponseDto> selectFileList(Long postId);

    // 파일 단건 조회 (다운로드용)
    FileResponseDto selectFile(Long fileId);

    int deleteFile(Long fileId);
}