package com.task.controller;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	public String hello(Model model, @RequestParam(value="page", defaultValue = "1") Integer pageNum) {
		
		List<NoticeDTO> list = noticeService.list(pageNum);
		
		Integer[] pageList = noticeService.getPageList(pageNum);
		model.addAttribute("pageList", pageList);
		
		model.addAttribute("noticeList", list);
		
		return "notice/list";
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
	
}
