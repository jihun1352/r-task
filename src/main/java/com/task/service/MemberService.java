package com.task.service;

import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.task.domain.Member;
import com.task.dto.MemberDTO;
import com.task.repository.MemberRepository;

@Service
public class MemberService {
	
	private final MemberRepository memberRepository;
	private final PasswordEncoder passwordEncoder; 
	
	public MemberService(MemberRepository memberRepository, PasswordEncoder passwordEncoder) {
		this.memberRepository = memberRepository;
		this.passwordEncoder = passwordEncoder;
	}
	
	public boolean save(MemberDTO memberDto) {
		// 아이디 중복 체크
		if(memberRepository.findByUserId(memberDto.getUserId()).isPresent()) {
			return false;
		}
		
		// 비밀번호 암호화
		String encPasswd = passwordEncoder.encode(memberDto.getUserPasswd());
		memberDto.setUserPasswd(encPasswd);
		
		memberRepository.save(memberDto.toEntity());
		
		return true;
	}
	
	public boolean login(MemberDTO memberDto) {
		
		// 아이디가 없을 경우
		if(!memberRepository.findByUserId(memberDto.getUserId()).isPresent()) { 
			return false; 
		}
		 
		Optional<Member> mem = memberRepository.findByUserId(memberDto.getUserId());
		
		return passwordEncoder.matches(memberDto.getUserPasswd(), mem.get().getUserPasswd());
	}
	
}
