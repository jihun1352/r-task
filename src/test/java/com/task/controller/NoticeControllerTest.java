package com.task.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.task.domain.Notice;
import com.task.repository.NoticeRepository;
import com.task.service.NoticeService;

@WebMvcTest
class NoticeControllerTest {

	@Autowired
	MockMvc mvc;
	@MockBean
	private NoticeRepository noticeRepository;
	
	@Test
	void test() {
		fail("Not yet implemented");
	}
	
	@Test
	void 게시글삭제() {
		//given
		
	}
	

}
