package com.task.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.task.domain.AttachFile;

public interface AttachFileRepository extends JpaRepository<AttachFile, Long> {
	
	@Query("select max(attach_file_id)+1 from AttachFile m")
	public Long maxAttachFileId();
	
	List<AttachFile> findAllByAttachFileId(Long attachFileId);
	
	public AttachFile findByIdAndAttachFileId(Long id, Long attachFileId); 
	
}
