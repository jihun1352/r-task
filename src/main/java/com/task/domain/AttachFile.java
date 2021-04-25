package com.task.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@Entity
public class AttachFile {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Long attachFileId;	
	private String originalName;
	private String aliasName;
	private String filePath;
	private String fileExt;
	
	@Builder
	public AttachFile(Long id, Long attachFileId, String originalName, String aliasName, String filePath, String fileExt) {
		this.id = id;
		this.attachFileId = attachFileId;
		this.originalName = originalName;
		this.aliasName = aliasName;
		this.filePath = filePath;
		this.fileExt = fileExt;
	}
	
}
