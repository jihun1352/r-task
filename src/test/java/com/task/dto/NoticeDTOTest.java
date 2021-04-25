package com.task.dto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import com.task.domain.Notice;

class NoticeDTOTest {

	@Test
	void 공지toEntity테스트() {
		//given
		NoticeDTO noticeDto = NoticeDTO.builder()
				.subject("notice1")
				.content("text")
				.regId("admin")
				.build();
		
		//when
		Notice notice = noticeDto.toEntity();
		
		//then
		assertThat(noticeDto.getSubject()).isEqualTo(notice.getSubject());
		assertThat(noticeDto.getContent()).isEqualTo(notice.getContent());
	}

}
