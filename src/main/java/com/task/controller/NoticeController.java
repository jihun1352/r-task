package com.task.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NoticeController {
	
	// 공지사항 목록
	@GetMapping("/")
	public String hello() {
		return "notice/list";
	}

	@GetMapping("/write")
	public String write() {
		return "notice/write";
	}
}
