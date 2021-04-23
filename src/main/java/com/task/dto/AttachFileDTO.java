package com.task.dto;

import com.task.domain.AttachFile;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class AttachFileDTO {
	private Long id;
	private Long attachFileId;
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

	@Builder
	public AttachFileDTO(Long id, Long attachFileId, String originalName, String aliasName, String filePath,
			String fileExt) {
		this.id = id;
		this.attachFileId = attachFileId;
		this.originalName = originalName;
		this.aliasName = aliasName;
		this.filePath = filePath;
		this.fileExt = fileExt;
	}
	
}
