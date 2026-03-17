package com.seoyeon.mini_server.file.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FileRequestDto {
    private Long postId;
    private String fileNm;
    private String filePath;
    private Long fileSize;
    private String fileExt;
}