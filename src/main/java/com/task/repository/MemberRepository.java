package com.task.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.task.domain.Member;

public interface MemberRepository extends JpaRepository<Member, String> {
	
	Optional<Member> findByUserId(String userId);
	
	@Query("select m from Member m where userId = :userId and userPasswd = :userPasswd")
	Member findMember(String userId, String userPasswd);
}
