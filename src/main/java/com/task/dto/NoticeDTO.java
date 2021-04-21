package com.task.dto;

import java.time.LocalDateTime;

import com.task.domain.BaseEntity;
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
	private LocalDateTime regDt;
	private LocalDateTime uptDt;
	
	public Notice toEntity() {
		return Notice.builder()
					 .subject(subject)
					 .content(content)
					 .regId(regId)
					 .build();
	}

	@Builder
	public NoticeDTO(Long id, String subject, String content, String regId, 
			LocalDateTime regDt, LocalDateTime uptDt ) {
		this.id = id;
		this.subject = subject;
		this.content = content;
		this.regId = regId;
		this.regDt = regDt;
		this.uptDt = uptDt;
	}
	
}
