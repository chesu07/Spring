package com.lsj.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lsj.spring.store.model.PlaceOrderService;
import com.lsj.spring.store.model.PurchaseOrderRequest;
import com.lsj.spring.store.model.PurchaseOrderResult;

public class PlaceOrderServiceIBatisMain {
	private PlaceOrderService placeOrderService;
	
	private PlaceOrderServiceIBatisMain(){
		String[] configLocations = new String[] { "transactionIbatis.xml" };
		ApplicationContext context = new ClassPathXmlApplicationContext(configLocations);
		placeOrderService = (PlaceOrderService) context.getBean("placeOrderService");
	}
	
	public void order(){
		PurchaseOrderRequest orderRequest = new PurchaseOrderRequest(); 
		orderRequest.setItemId(1);
		orderRequest.setAddress("서울 서초구");
		PurchaseOrderResult orderResult = placeOrderService.order(orderRequest);
		System.out.println("1. 주문상태 정보");
		System.out.println("[아이템] : " + orderResult.getItem().getName());
		System.out.println("[가격] : " + orderResult.getPaymentInfo().getPrice());
		
		System.out.println("\n2. 요청 정보");
		System.out.println("[주소] : " + orderResult.getOrder().getAddress());
		 
	}
	
	public static void main(String[] args) {
		try{
			PlaceOrderServiceIBatisMain test = new PlaceOrderServiceIBatisMain();
			test.order();			
		}catch(Exception e){
			e.printStackTrace();
		}
				
	}
}