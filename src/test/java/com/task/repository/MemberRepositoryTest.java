package com.task.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.task.model.MemberVO;

@SpringBootTest
class MemberRepositoryTest {
	
	private MemberRepository memberRepository;
	
	@Autowired
	public MemberRepositoryTest(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}
	
	@Test
	void test(MemberVO mem) {
		mem.setUserId("jihun");
		mem.setUserPasswd("1234");
		System.out.println( " || name : "+mem.getUserPasswd()+ " || seq: "+mem.getUserId());
		memberRepository.save(mem);
	}

}
