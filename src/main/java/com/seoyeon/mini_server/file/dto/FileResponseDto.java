package com.seoyeon.mini_server.file.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FileResponseDto {
    private Long fileId;
    private Long postId;
    private String fileNm;
    private String filePath;
    private Long fileSize;
    private String fileExt;
    private LocalDateTime regDt;
}