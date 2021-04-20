package com.task.service;

import java.util.Optional;

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
		memberRepository.save(vo);
	}
	
	public boolean idCheck(String userId) {		
		return memberRepository.findById(userId).isPresent();
	}
	
	public boolean login(MemberVO vo) {
		Optional<MemberVO> loginSucces = Optional.ofNullable(memberRepository.findMember(vo.getUserId(), vo.getUserPasswd()));		
		return loginSucces.isPresent();
	}
	
}
