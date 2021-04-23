package com.task.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.task.domain.Notice;
import com.task.dto.NoticeDTO;
import com.task.repository.NoticeRepository;

@Service
public class NoticeService {
	
	private final NoticeRepository noticeRepository;

	public NoticeService(NoticeRepository noticeRepository) {
		this.noticeRepository = noticeRepository;
	}
	
	@Transactional
	public Long save(NoticeDTO noticeDto) {
		return noticeRepository.save(noticeDto.toEntity()).getId();
	}
	
	@Transactional
	public Page<Notice> list(Pageable pageable) {	
		return noticeRepository.findAll(pageable);
	}
	
	public NoticeDTO view(long id) {
		Optional<Notice> noticeOp = noticeRepository.findById(id);
		
		Notice notice = noticeOp.get();
		
		NoticeDTO noticeDto = NoticeDTO.builder()
				.id(notice.getId())
				.subject(notice.getSubject())
				.content(notice.getContent())
				.regId(notice.getRegId())
				.attachFileId(notice.getAttachFileId())
				.regDt(notice.getRegDt())
				.uptDt(notice.getUptDt())
				.build();
		
		return noticeDto;
	}
	
}
