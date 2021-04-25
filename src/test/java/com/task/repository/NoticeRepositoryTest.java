package com.task.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.transaction.annotation.Transactional;

import com.task.domain.Notice;
import com.task.dto.NoticeDTO;

@DataJpaTest
@Transactional
class NoticeRepositoryTest {
	
	@Autowired
	private NoticeRepository noticeRepository;
	
	@Test
	void 공지등록() {
		//given
		NoticeDTO noticeDto = NoticeDTO.builder()
				.subject("notice1")
				.content("text")
				.regId("admin")
				.build();		
		//when
		Notice notice = noticeRepository.save(noticeDto.toEntity());		
		//then
		assertThat(noticeDto.getSubject()).isEqualTo(notice.getSubject());
		assertThat(noticeDto.getContent()).isEqualTo(notice.getContent());
	}
	@Test
	void 공지상세() {
		//given
		NoticeDTO noticeDto = NoticeDTO.builder()
				.subject("notice1")
				.content("text")
				.regId("admin")
				.build();
		Notice notice = noticeRepository.save(noticeDto.toEntity());
		//when
		Optional<Notice> detailNotice = noticeRepository.findById(notice.getId());
		//then
		assertThat(detailNotice.get()).isEqualTo(notice);
	}
	@Test
	void 공지목록() {
		//given
		NoticeDTO noticeDto = NoticeDTO.builder()
				.subject("notice1")
				.content("text")
				.regId("admin")
				.build();
		noticeRepository.save(noticeDto.toEntity());
		noticeRepository.save(noticeDto.toEntity());
		noticeRepository.save(noticeDto.toEntity());
		//when
		List<Notice> noticeList = noticeRepository.findAll();
		//then
		assertThat(noticeList.size()).isEqualTo(3);
	}
	@Test
	void 공지삭제() {
		//given
		NoticeDTO noticeDto = NoticeDTO.builder()
				.subject("notice1")
				.content("text")
				.regId("admin").build();
		Notice notice = noticeRepository.save(noticeDto.toEntity());
		Long id = notice.getId();
		//when
		noticeRepository.deleteById(notice.getId());
		//then
		Optional<Notice> detailNotice = noticeRepository.findById(id);		
		assertThat(detailNotice.isPresent()).isEqualTo(false);
	}
}
