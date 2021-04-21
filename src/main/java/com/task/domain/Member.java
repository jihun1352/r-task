package com.task.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@Entity
public class Member {
	@Id	
	private String userId;
	@Column(nullable = false)
	private String userPasswd;
	
	@Builder
	public Member(String userId, String userPasswd) {
		this.userId = userId;
		this.userPasswd = userPasswd;
	}
		
	
}
