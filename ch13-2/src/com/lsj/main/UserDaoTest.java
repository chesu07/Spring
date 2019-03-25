package com.lsj.main;

import java.sql.SQLException;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.lsj.dao.UserDAO;
import com.lsj.factory.DaoFactory;
import com.lsj.model.UserVO;

public class UserDaoTest {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		try{			
			//1.커넥션 객체를 생성자의 파라미터로 넘겨주는 방식
			//ConnectionMaker connectionMaker = new NConnectionMaker();
			//UserDAO dao = new UserDAO(connectionMaker);
						
			
			//2.DAO에서 커넥션 객체를 생성하는 방식
			//UserDAO dao = new UserDAO();	
			
						
			//3.오브젝트 팩토리를 사용하는 방식
			//UserDAO dao = new DaoFactory().userDao();
			
			
			//4.어플리케이션 컨텍스트를 적용한 방식 - 오브젝트 빈 팩토리 사용
			AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class);			
			UserDAO dao = context.getBean("userDao", UserDAO.class); //getBean("빈네임(=메소드명)", 리턴타입) 
			 			 
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
			
			
			/*
			 * 오브젝트 스코프 
			 * 1) 직접 생성한 클래스 오브젝트(여기서는 DaoFactory)
			 */
			
			/*
			DaoFactory factory = new DaoFactory();
			UserDAO objectOne = factory.userDao();	 
			UserDAO objectTwo = factory.userDao();	
			System.out.println(objectOne);	//여기서의 출력값과
			System.out.println(objectTwo);	//이곳의 출력값이 매번 다름을 알 수 있다.
			*/			
			
			
			/*
			 * 싱글톤 레지스트리
			 * 1) 스프링은 싱글톤으로 빈을 만든다. 
			 * 2) 스프링은 기본적으로 별다른 설정을 하지 않아도 내부에서 생성하는 빈 오브젝트를 모두 싱글톤으로 만든다.
			 * 3) 즉 애플리캐이션 안에 제한된 수, 보통 한개의 오브젝트만 만들어서 사용하는 것이 싱글톤 패턴의 원리이다.
			 * 4) 스프링은 직접 싱글톤 형태의 오브젝트를 만들고 관리하는 기능을 제공한다. 즉 싱글톤 레지스트리이다.
			 */		
			
			/*
			UserDAO singleOne = context.getBean("userDao", UserDAO.class);
			UserDAO singleTwo = context.getBean("userDao", UserDAO.class);
			System.out.println(singleOne);	//여기서의 출력값과
			System.out.println(singleTwo);	//이곳의 출력값이 항상 같을 알 수 있다.
			*/
			
		}catch(Exception e){
			e.printStackTrace();
		}			
	}
}
