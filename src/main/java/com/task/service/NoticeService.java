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
	
	// 페이지 갯수 
	private static final int PAGE_BLOCK_COUNT = 5;
	// 한 페이지에 보여줄 공지사항 수
	private static final int PAGE_LIST_COUNT = 3;
	
	private final NoticeRepository noticeRepository;

	public NoticeService(NoticeRepository noticeRepository) {
		this.noticeRepository = noticeRepository;
	}
	
	@Transactional
	public Long save(NoticeDTO noticeDto) {
		return noticeRepository.save(noticeDto.toEntity()).getId();
	}
	
	@Transactional
	public List<NoticeDTO> list(Integer pageNum) {	
		PageRequest pageRequest = PageRequest.of(pageNum-1, PAGE_LIST_COUNT, Sort.by("regDt").descending());
		
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
	
	// 페이징
	public Integer[] getPageList(Integer curPageNum) {
		// 페이지 수 5로 고정
		Integer[] pageList = new Integer[PAGE_BLOCK_COUNT];
		
		// 총 게시글 수
		Double NoticeTotalCount = Double.valueOf(this.getNoticeCount());
		// 총 게시글 수 기준으로 계산한 마지막 페이지 번호 계산
		Integer totalLastPageNum = (int)(Math.ceil((NoticeTotalCount/PAGE_LIST_COUNT)));
		// 현재 페이지를 기준으로 블럭의 마지막 페이지 번호 계산
		Integer blockLastPageNum = (totalLastPageNum > curPageNum + PAGE_BLOCK_COUNT)
				? curPageNum + PAGE_BLOCK_COUNT : totalLastPageNum;
						
		// 페이지 시작 번호 조정
		curPageNum = (curPageNum<=3) ? 1 : curPageNum-2;
		// 페이지 번호 할당
		for(int val=curPageNum, i=0; val<=blockLastPageNum; val++, i++) {
			pageList[i] = val;
		}
		
		return pageList;
	}
	
	// 총 갯수
	public Long getNoticeCount() {
		return noticeRepository.count();
	}
	
	
	
}
