package com.lsj.spring.store.model;

public interface PlaceOrderService { 
	public PurchaseOrderResult order(PurchaseOrderRequest buyRequest) throws ItemNotFoundException;
	
}
