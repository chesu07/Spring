package com.lsj.spring.service;

public class LoginCommand {
	private String userId;
	private String password;
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getUserId() {
		return userId;
	}
	public String getPassword() {
		return password;
	}
}
