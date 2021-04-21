package com.task.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

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
	public List<NoticeDTO> list() {	
		PageRequest pageRequest = PageRequest.of(0, 3, Sort.by("regDt").descending());
		
		List<Notice> list = noticeRepository.findAll(pageRequest).getContent();
		List<NoticeDTO> noticeList = new ArrayList<NoticeDTO>();
		
		for(Notice notice : list) {
			NoticeDTO noticeDTO = NoticeDTO.builder()
					.id(notice.getId())
					.subject(notice.getSubject())
					.regId(notice.getRegId())
					.regDt(notice.getRegDt())
					.build();
			
			noticeList.add(noticeDTO);
		}
		
		return noticeList;
	}
	
	
}
