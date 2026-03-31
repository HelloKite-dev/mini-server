package com.seoyeon.mini_server.file.controller;

import java.util.List;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.seoyeon.mini_server.file.dto.FileResponseDto;
import com.seoyeon.mini_server.file.service.FileService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/files")
@RequiredArgsConstructor
public class FileController {
	private final FileService fileService;

	// 파일 다운로드
	@GetMapping("/{fileId}")
	public ResponseEntity<Resource> downloadFile(@PathVariable Long fileId) throws Exception {
		FileResponseDto fileDto = fileService.selectFile(fileId);
		Resource resource = new FileSystemResource(fileDto.getFilePath());

		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileDto.getFileNm() + "\"")
				.body(resource);
	}
	
	// 파일 업로드
	@PostMapping
	public int uploadFile(@RequestParam Long postId, @RequestParam MultipartFile file) throws Exception {
		return fileService.uploadFile(postId, file);
	}

	// 파일 목록 조회
	@GetMapping("/post/{postId}")
	public List<FileResponseDto> selectFileList(@PathVariable Long postId) {
		return fileService.selectFileList(postId);
	}

	@DeleteMapping("/{fileId}")
	public int deleteFile(@PathVariable Long fileId) {
		return fileService.deleteFile(fileId);
	}
}
