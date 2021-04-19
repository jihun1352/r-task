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
	void test() {
		MemberVO mem = new MemberVO();
		mem.setUserId("1");
		mem.setUserName("jihun");
		System.out.println("id : "+mem.getId()+ " || name : "+mem.getUserName()+ " || seq: "+mem.getUserId());
		memberRepository.save(mem);
	}

}
