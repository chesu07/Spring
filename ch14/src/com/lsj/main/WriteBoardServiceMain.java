package com.lsj.main;

import java.sql.SQLException;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.lsj.model.BoardDAO;
import com.lsj.model.BoardVO;
import com.lsj.spring.WriteBoardService;

public class WriteBoardServiceMain {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {				
		/*
		//스프링을 이용한 어플리케이션을 개발할 때 단순히 빈 객체생성 기능만을 제공하는 BeanFactory 보다는 ApplicationContext 인터페이스의 구현 클래스를 주로 사용한다.
		Resource resource = new ClassPathResource("applicationContext.xml");
		BeanFactory beanFactory = new XmlBeanFactory(resource);		
		WriteBoardService boardService = (WriteBoardService) beanFactory.getBean("writeBoardService");		
		*/
		
		ApplicationContext context = new GenericXmlApplicationContext("applicationContext.xml");
		//WriteBoardService 객체 생성 -> DB Connection 완료
		WriteBoardService boardService = (WriteBoardService) context.getBean("writeBoardService");
		
		//빈이 Singleton으로써 취급되었는지 여부 반환
		System.out.println("[Singleton 여부] " + context.isSingleton("writeBoardService"));
		
		//VO setting
		BoardVO boardVO = new BoardVO();		
		boardVO.setId("chesu07"); 
		boardVO.setName("daebbang");
		boardVO.setTitle("blueHill");
		
		//Insert
		boardService.write(boardVO);
	}
}





