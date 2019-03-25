package com.lsj.spring.model;

import java.util.Date;

//모델 클래스
public class GuestMessage {
	private Integer id;
	private String guestName;
	private String message;
	private Date registryDate;
	
	
	public void setId(Integer id) {
		this.id = id;
	}	
	public void setGuestName(String guestName) {
		this.guestName = guestName;
	}
	public void setMessage(String message) {
		this.message = message;
	}	
	public void setRegistryDate(Date registryDate) {
		this.registryDate = registryDate;
	}
	
	public Integer getId() {
		return id;
	}
	public String getGuestName() {
		return guestName;
	}	
	public String getMessage() {
		return message;
	}
	public Date getRegistryDate() {
		return registryDate;
	}
	
}
