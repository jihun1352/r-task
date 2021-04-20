package com.task.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.task.model.MemberVO;
import com.task.service.MemberService;

@Controller
public class MemberController {
	
	private final MemberService memberService;
	
	@Autowired
	public MemberController(MemberService memberService) {
		this.memberService = memberService;
	}
	
	// 로그인 폼
	@GetMapping("/login")
	public String login(Model model) {		
		return "member/login";
	}
	// 로그인
	@PostMapping("/login")
	public String loginf(HttpServletRequest request, MemberVO vo, RedirectAttributes redirectAttributes) {
		
		if(!memberService.login(vo)) {
			redirectAttributes.addFlashAttribute("message", "아이디가 없거나 비밀번호가 일치하지 않습니다.");
			return "redirect:/login";
		}
		request.getSession().setAttribute("user_id", vo.getUserId());
		redirectAttributes.addFlashAttribute("message", "로그인");
		
		return "redirect:/";
	}
	// 로그아웃
	@GetMapping("/logout")
	public String logout(HttpServletRequest request, RedirectAttributes redirectAttributes) {
		request.getSession().removeAttribute("user_id");
		redirectAttributes.addFlashAttribute("message", "로그아웃");
		
		return "redirect:/";
	}
	
	// 회원가입 폼
	@GetMapping("/join")
	public String join() {
		return "member/join";
	}	
	// 회원가입
	@PostMapping("/join")
	public String joinf(MemberVO vo, RedirectAttributes redirectAttributes) {
		
		if(!memberService.save(vo)) {
			redirectAttributes.addFlashAttribute("message", "이미 사용 중인 id 입니다.");
			return "redirect:/join";
		};
		
		redirectAttributes.addFlashAttribute("message", "가입이 완료 되었습니다.");

		return "redirect:/login";
	}
	
	
}
