package com.task.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.task.domain.AttachFile;

public interface AttachFileRepository extends JpaRepository<AttachFile, Long> {
	
	@Query("select max(attach_file_id)+1 from AttachFile m")
	public String maxAttachFileId();
}
