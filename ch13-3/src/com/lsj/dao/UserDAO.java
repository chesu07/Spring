package com.lsj.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.lsj.factory.DaoFactory;
import com.lsj.impl.ConnectionMaker;
import com.lsj.model.UserVO;


public class UserDAO{
	private static UserDAO instance;
	private ConnectionMaker connectionMaker;
	private Connection c; 
	private PreparedStatement ps; 
	private UserVO user;
	
	/*
	//DaoFactory를 이용하는 생성자
	public UserDAO(){
		DaoFactory daoFactory = new DaoFactory();
		this.connectionMaker = daoFactory.connectionMaker();
	}
	*/
	
	/*
	//의존관계 검색을 이용하는 생성자
	public UserDAO(){
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class);
		this.connectionMaker = context.getBean("connectionMaker", ConnectionMaker.class); 
	}
	*/
	
	//관계설정 책임 분리전의 생성자 코드
	private UserDAO(){
		connectionMaker = new NConnectionMaker(); 
	}
		
	//의존관계 주입(DI)을 위한 코드
	public UserDAO(ConnectionMaker connectionMaker){
		this.connectionMaker = connectionMaker;
	}
	
	//static 팩토리 메서드
	public static synchronized UserDAO getInstance(){
		if(instance == null){
			instance = new UserDAO();
		}
		return instance;
	}
	
	public void add(UserVO user) throws ClassNotFoundException, SQLException{	
		c = connectionMaker.makeConnection();	//CountingDaoFactory.realConnectionMaker 메소드가 리턴하는 클래스의 makeConnection()을 의미함
		ps = c.prepareStatement("insert into myuser(id, name, pass) values(?,?,?)");
		ps.setString(1, user.getId());
		ps.setString(2, user.getName());
		ps.setString(3, user.getPass());
		ps.executeUpdate();
		ps.close();	
	}
	
	public UserVO get(String id) throws ClassNotFoundException, SQLException{	
		c = connectionMaker.makeConnection();
		ps = c.prepareStatement("select * from myuser where id = ?");
		ps.setString(1, id);
		ResultSet rs = ps.executeQuery();
		rs.next();
		
		user = new UserVO();
		user.setId(rs.getString("id"));
		user.setName(rs.getString("name"));
		user.setPass(rs.getString("pass"));
		
		rs.close();
		ps.close();
		
		return user;
	}
	
}
