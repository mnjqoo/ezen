package com.edu.exam.exam3.vo;

import lombok.Data;

//@Getter
//@Setter
//@ToString
@Data
public class MemberVO {
	
	private String userId;
	private String userPw;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPw() {
		return userPw;
	}
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
	@Override
	public String toString() {
		return "MemberVO [userId=" + userId + ", userPw=" + userPw + "]";
	}
	
	
}
