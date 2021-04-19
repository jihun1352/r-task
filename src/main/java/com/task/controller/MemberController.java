package com.task.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.task.model.MemberVO;
import com.task.service.MemberService;

@Controller
public class MemberController {
	
	private MemberService memberService;
	
	@Autowired
	public MemberController(MemberService memberService) {
		this.memberService = memberService;
	}
	
	@GetMapping("/")
	public String hello() {
		MemberVO vo = new MemberVO();
		memberService.save(vo);
		
		return "view";
	}
}
