package com.task.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.task.model.MemberVO;
import com.task.repository.MemberRepository;

@Service
public class MemberService {
	
	private final MemberRepository memberRepository;
	private final PasswordEncoder passwordEncoder; 
	
	@Autowired
	public MemberService(MemberRepository memberRepository, PasswordEncoder passwordEncoder) {
		this.memberRepository = memberRepository;
		this.passwordEncoder = passwordEncoder;
	}
	
	public boolean save(MemberVO vo) {
		// 아이디 중복 체크
		if(memberRepository.findById(vo.getUserId()).isPresent()) {
			return false;
		}
		
		// 비밀번호 암호화
		String encPasswd = passwordEncoder.encode(vo.getUserPasswd());
		vo.setUserPasswd(encPasswd);
		
		memberRepository.save(vo);
		
		return true;
	}
	
	public boolean login(MemberVO vo) {
		// 아이디가 없을 경우
		if(!memberRepository.findById(vo.getUserId()).isPresent()) {
			return false;
		}
		Optional<MemberVO> mem = memberRepository.findById(vo.getUserId());		
		
		return passwordEncoder.matches(vo.getUserPasswd(), mem.get().getUserPasswd());
	}
	
}
