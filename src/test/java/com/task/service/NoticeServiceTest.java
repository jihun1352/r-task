package com.task.service;

import static org.junit.jupiter.api.Assertions.fail;

import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.task.domain.Notice;
import com.task.dto.NoticeDTO;
import com.task.repository.NoticeRepository;

@Transactional
class NoticeServiceTest {
	
	@Autowired
	private NoticeService noticeService;
	@Autowired
	private NoticeRepository noticeRepository;
	
	@Test
	void 공지사항삭제() {
		//given
		NoticeDTO noticeDto = NoticeDTO.builder()
				.subject("notice1")
				.content("text")
				.regId("admin")
				.build();
		System.out.println("id " + noticeDto.getId() + " || ");
		Notice notice = noticeRepository.save(noticeDto.toEntity());
		
		System.out.println("id " + notice.getId() + " || ");
		//when
		//noticeRepository.deleteById(notice.getId());
		//System.out.println("id@@@ " + notice.getId());
		//then
		//Assertions.assertThat(d).is
		
		/*		
		Notice notice = Notice.builder()
				.id(1L)
				.subject("notice1")
				.content("text")
				.regId("admin")
				.build();
		*/
		fail("Not yet implemented");
	}

}
