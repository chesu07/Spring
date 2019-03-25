package com.lsj.spring.store.model;

public class PurchaseOrderRequest {
	private Integer itemId;
	private String address;
	 
	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public Integer getItemId() {
		return itemId;
	}
	public String getAddress() {
		return address;
	}
}
