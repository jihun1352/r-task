package com.task.dto;

import com.task.domain.Member;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class MemberDTO {
	
	private String userId;
	private String userPasswd;
	
	public Member toEntity() {
		return Member.builder()
					 .userId(userId)
					 .userPasswd(userPasswd)
					 .build();
	}
	
	@Builder
	public MemberDTO(String userId, String userPasswd) {
		this.userId = userId;
		this.userPasswd = userPasswd;
	}	
}
