package com.lsj.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lsj.spring.store.model.PlaceOrderService;
import com.lsj.spring.store.model.PurchaseOrderRequest;
import com.lsj.spring.store.model.PurchaseOrderResult;

public class PlaceOrderServiceMyBatisMain {
	private PlaceOrderService placeOrderService;
	
	private PlaceOrderServiceMyBatisMain(){
		try{
			String[] configLocations = new String[] { "transactionMybatis.xml" };
			ApplicationContext context = new ClassPathXmlApplicationContext(configLocations);
			placeOrderService = (PlaceOrderService) context.getBean("placeOrderService");
			
		}catch(Exception e){ 
			e.printStackTrace(); 
		}
		
	}
	
	public void order(){
		try{
			PurchaseOrderRequest orderRequest = new PurchaseOrderRequest(); 
			orderRequest.setItemId(2);
			orderRequest.setAddress("서울 강남구"); 
			PurchaseOrderResult orderResult = placeOrderService.order(orderRequest);
			System.out.println("1. 주문상태 정보");
			System.out.println("[아이템] : " + orderResult.getItem().getName());
			System.out.println("[가격] : " + orderResult.getPaymentInfo().getPrice());
			
			System.out.println("\n2. 요청 정보");
			System.out.println("[주소] : " + orderResult.getOrder().getAddress());
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		try{
			PlaceOrderServiceMyBatisMain test = new PlaceOrderServiceMyBatisMain();
			test.order();			
		}catch(Exception e){
			e.printStackTrace();
		}
				
	}
}