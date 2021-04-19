package com.task.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.task.model.MemberVO;

public interface MemberRepository extends JpaRepository<MemberVO, Long> {

}
