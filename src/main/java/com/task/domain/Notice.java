package com.task.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
public class Notice extends BaseEntity{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String subject;
	@Column(columnDefinition = "TEXT")
	private String content;
	@Column(nullable = false)
	private String regId;
	private Long attachFileId;
	
	@Builder
	public Notice(String subject, String content, String regId, Long attachFileId) {
		this.subject = subject;
		this.content = content;
		this.regId = regId;
		this.attachFileId = attachFileId;
	}
	
}
