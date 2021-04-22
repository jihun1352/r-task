package com.task.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.task.domain.Notice;
import com.task.dto.NoticeDTO;
import com.task.service.NoticeService;

@Controller
public class NoticeController {
	
	private final NoticeService noticeService;
	
	public NoticeController(NoticeService noticeService) {
		this.noticeService = noticeService;
	}

	// 공지사항 목록
	@GetMapping("/")
	public String hello(@PageableDefault(size=1,sort="id",direction = Sort.Direction.DESC) Pageable pageable,
			Model model, Integer pageNum) {
		
		Page<Notice> list = noticeService.list(pageable); 
		
		int pageNumber = list.getPageable().getPageNumber();	//현재페이지
		int totalPage = list.getTotalPages();					//총 페이지 수
		int pageBlock = 5;										//보여지는 페이지 수
		int startPage = ((pageNumber)/pageBlock)*pageBlock+1;
		int endPage = startPage + pageBlock -1;
		endPage = totalPage < endPage? totalPage:endPage;
		
		model.addAttribute("noticeList", list);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		
		return "notice/list";
	}
	
	// 공지사항 상세 조회
	@GetMapping("/notice/{id}")
	public String view(@PathVariable("id") long id, Model model) {
		
		NoticeDTO noticeDto = noticeService.view(id);
		
		model.addAttribute("result", noticeDto);
		
		return "notice/view";
	}

	// 공지사항 등록 폼
	@GetMapping("/notice/post")
	public String write() {		
		return "notice/write";
	}
	// 공지사항 등록
	@PostMapping("/notice/post")
	public String writef(NoticeDTO noticeDto, HttpServletRequest request, 
			RedirectAttributes redirectAttributes) {		
		noticeDto.setRegId((String) request.getSession().getAttribute("user_id"));
		
		noticeService.save(noticeDto);
		
		redirectAttributes.addFlashAttribute("message", "등록 되었습니다.");
		
		return "redirect:/";
	}
	
	// 공지사항 수정 폼	
	@GetMapping("/notice/post/{id}")
	public String modify(@PathVariable("id") long id) {		
		
		System.out.println("!@#!@#" + id);
		
		return "notice/modify";
	}
	// 공지사항 수정	
	@PutMapping("/notice/post/{id}")
	public String modifyf(@PathVariable("id") long id) {

		System.out.println("!@#!@#" + id);

		return "notice/modify";
	}
	
}
