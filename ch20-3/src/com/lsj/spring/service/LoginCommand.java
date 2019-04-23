package com.lsj.spring.service;

//커맨드 클래스
public class LoginCommand {
	private String userId;
	private String password;
	
	public String getUserId() {
		return userId;
	}
	public String getPassword() {
		return password;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
