package com.lsj.factory;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import com.lsj.dao.UserDAO;

//Configuration은 어플리케이션 컨텍스트 또는 빈 팩토리가 사용할 설정정보라는 표시
@Configuration
public class DaoFactory {
	//Bean은 오브젝트 생성을 담당하는 ioc용 메서드라는 표시
	@Bean
	public DataSource dataSource(){
		SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
		dataSource.setDriverClass(oracle.jdbc.driver.OracleDriver.class);
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:DHDB");
		dataSource.setUsername("scott");
		dataSource.setPassword("snrnrh21");
		return dataSource;
	}
	
	@Bean
	public UserDAO userDao(){
		UserDAO userDao = new UserDAO();
		userDao.setDataSource(dataSource());
		return userDao;		
	} 
}
