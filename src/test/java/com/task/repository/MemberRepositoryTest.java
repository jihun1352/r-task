package com.task.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.task.domain.Member;
import com.task.dto.MemberDTO;

@SpringBootTest
class MemberRepositoryTest {
	
	private MemberRepository memberRepository;
	
	@Autowired
	public MemberRepositoryTest(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}
	
	@Test
	void test(MemberDTO memberDto) {
		memberDto.setUserId("jihun");
		memberDto.setUserPasswd("1234");
		System.out.println( " || name : "+memberDto.getUserPasswd()+ " || seq: "+memberDto.getUserId());
		memberRepository.save(memberDto.toEntity());
	}

}
