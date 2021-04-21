package com.task.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.task.domain.Notice;

public interface NoticeRepository extends JpaRepository<Notice, Long> {
	
}
