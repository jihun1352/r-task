package com.task.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.task.model.MemberVO;

public interface MemberRepository extends JpaRepository<MemberVO, String> {
	
	@Query("select m from MemberVO m where userId = :userId and userPasswd = :userPasswd")
	MemberVO findMember(String userId, String userPasswd);
	
}
