package com.task.dto;

import com.task.domain.AttachFile;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AttachFileDTO {
	private Long id;
	private String attachFileId;
	private String originalName;
	private String aliasName;
	private String filePath;
	private String fileExt;
	
	public AttachFile toEntity() {
		return AttachFile.builder()
				.id(id)
				.attachFileId(attachFileId)
				.originalName(originalName)
				.aliasName(aliasName)
				.filePath(filePath)
				.fileExt(fileExt)
				.build();
	}
}
