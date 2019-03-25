package com.lsj.factory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.lsj.dao.DConnectionMaker;
import com.lsj.dao.UserDAO;
import com.lsj.impl.ConnectionMaker;

//Configuration은 어플리케이션 컨텍스트 또는 빈 팩토리가 사용할 설정정보라는 표시
@Configuration
public class DaoFactory {
	//Bean은 오브젝트 생성을 담당하는 ioc용 메서드라는 표시
	@Bean
	public UserDAO userDao(){
		UserDAO dao = new UserDAO(connectionMaker());
		return dao;
	} 
	@Bean
	public ConnectionMaker connectionMaker() {
		ConnectionMaker connectionMaker = new DConnectionMaker();
		return connectionMaker;
	}	
}
