package com.lsj.main;

import java.sql.SQLException;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.lsj.dao.CountingConnectionMaker;
import com.lsj.dao.UserDAO;
import com.lsj.factory.CountingDaoFactory;
import com.lsj.model.UserVO;

public class CountingConnectionMakerTest {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {		
		try{
			AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(CountingDaoFactory.class);
			UserDAO dao = context.getBean("userDao", UserDAO.class);
			
			//VO setting		
			UserVO userOne = new UserVO();		
			userOne.setName("사용자_1");
			userOne.setId("ID_1"); 
			userOne.setPass("test1234");				
						
			//Insert
			dao.add(userOne);		
			System.out.println("[INSERT] " + userOne.getId()); 
			
			//Select
			UserVO userTwo = dao.get(userOne.getId());
			System.out.println("[SELECT]: " + userTwo.getName());
			System.out.println("[SELECT]: " + userTwo.getPass());
			System.out.println("[SELECT]: " + userTwo.getId());
			
			//DB연결 횟수
			CountingConnectionMaker ccm = context.getBean("connectionMaker", CountingConnectionMaker.class);
			System.out.println("Counting counter : " + ccm.getCounter()); 
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
	}
}
