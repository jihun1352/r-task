package com.task.dto;

import java.time.LocalDateTime;

import com.task.domain.Notice;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class NoticeDTO {
	private Long id;
	private String subject;
	private String content;
	private String regId;
	private Long attachFileId;
	private LocalDateTime regDt;
	private LocalDateTime uptDt;
	
	public Notice toEntity() {
		return Notice.builder()
					 .subject(subject)
					 .content(content)
					 .regId(regId)
					 .attachFileId(attachFileId)
					 .build();
	}

	@Builder
	public NoticeDTO(Long id, String subject, String content, String regId, Long attachFileId,
			LocalDateTime regDt, LocalDateTime uptDt ) {
		this.id = id;
		this.subject = subject;
		this.content = content;
		this.regId = regId;
		this.attachFileId = attachFileId;
		this.regDt = regDt;
		this.uptDt = uptDt;
	}
	
}
