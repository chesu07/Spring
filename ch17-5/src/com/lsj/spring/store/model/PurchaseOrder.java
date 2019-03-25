package com.lsj.spring.store.model;

public class PurchaseOrder {
	private Integer id;
	private Integer itemId;
	private String address;
	private Integer paymentInfoId; 
	
	public PurchaseOrder() { }
	public PurchaseOrder(Integer itemId, String address, Integer paymentInfoId){
		this.itemId = itemId;
		this.address = address;
		this.paymentInfoId = paymentInfoId;
	}
	
	public Integer getId() {
		return id;
	}
	public Integer getItemId() {
		return itemId;
	}
	public String getAddress() {
		return address;
	}
	public Integer getPaymentInfoId() {
		return paymentInfoId;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setPaymentInfoId(Integer paymentInfoId) {
		this.paymentInfoId = paymentInfoId;
	}
}
