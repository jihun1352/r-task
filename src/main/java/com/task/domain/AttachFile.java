package com.task.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Builder;
import lombok.Getter;

@Getter
@Entity
public class AttachFile {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(columnDefinition = "number default '0'")
	private String attachFileId;	
	private String originalName;
	private String aliasName;
	private String filePath;
	private String fileExt;
	
	@Builder
	public AttachFile(Long id, String attachFileId, String originalName, String aliasName, String filePath, String fileExt) {
		this.id = id;
		this.attachFileId = attachFileId;
		this.originalName = originalName;
		this.aliasName = aliasName;
		this.filePath = filePath;
		this.fileExt = fileExt;
	}
}
