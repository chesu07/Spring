package com.lsj.factory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.lsj.dao.CountingConnectionMaker;
import com.lsj.dao.NConnectionMaker;
import com.lsj.dao.UserDAO;
import com.lsj.impl.ConnectionMaker;

@Configuration
public class CountingDaoFactory {
	@Bean
	public UserDAO userDao(){
		return new UserDAO(connectionMaker());		
	}
	
	@Bean
	public ConnectionMaker connectionMaker(){
		return new CountingConnectionMaker(realConnectionMaker());		
	} 
	
	@Bean
	public ConnectionMaker realConnectionMaker(){
		return new NConnectionMaker();
	}
}
