package com.seoyeon.mini_server.file.service;

import java.io.File;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.seoyeon.mini_server.file.dao.FileDao;
import com.seoyeon.mini_server.file.dto.FileRequestDto;
import com.seoyeon.mini_server.file.dto.FileResponseDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FileService {
    private final FileDao fileDao;

    @Value("${file.upload-dir}")
    private String uploadDir;

    // 파일 업로드
    public int uploadFile(Long postId, MultipartFile file) throws Exception {
        String originalName = file.getOriginalFilename();
        String ext = originalName.substring(originalName.lastIndexOf(".") + 1);
        String savedName = UUID.randomUUID().toString() + "." + ext;
        String filePath = uploadDir + "/" + savedName;

        file.transferTo(new File(filePath));

        FileRequestDto dto = new FileRequestDto();
        dto.setPostId(postId);
        dto.setFileNm(originalName);
        dto.setFilePath(filePath);
        dto.setFileSize(file.getSize());
        dto.setFileExt(ext);

        return fileDao.insertFile(dto);
    }

    // 게시글 파일 목록 조회
    public List<FileResponseDto> selectFileList(Long postId) {
        return fileDao.selectFileList(postId);
    }

    // 파일 단건 조회 (다운로드용)
    public FileResponseDto selectFile(Long fileId) {
        return fileDao.selectFile(fileId);
    }
}