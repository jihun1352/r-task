package com.task.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.task.domain.Member;

public interface MemberRepository extends JpaRepository<Member, String> {
	
	public Optional<Member> findByUserId(String userId);
}
