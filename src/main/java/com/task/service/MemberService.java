package com.task.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.task.model.MemberVO;
import com.task.repository.MemberRepository;

@Service
public class MemberService {
	
	private MemberRepository memberRepository;
	
	@Autowired
	public MemberService(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}
	
	public void save(MemberVO vo) {
		vo.setUserId("13");
		vo.setUserName("jihun");
		
		memberRepository.save(vo);
	}
}
