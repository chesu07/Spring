package com.lsj.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.lsj.impl.ConnectionMaker;
import com.lsj.model.UserVO;


public class UserDAO{
	private static UserDAO instance;
	private ConnectionMaker connectionMaker;
	private Connection c; 
	private PreparedStatement ps; 
	private UserVO user;
	private DataSource dataSource;
	
	//dataSource 인터페이스를 사용할 
	public void setDataSource(DataSource dataSource){
		this.dataSource = dataSource;		
	}
			
	public void add(UserVO user) throws ClassNotFoundException, SQLException{	
		//c = connectionMaker.makeConnection();	//CountingDaoFactory.realConnectionMaker 메소드가 리턴하는 클래스의 makeConnection()을 의미함		
		Connection c = dataSource.getConnection();	//dataSource 인터페이스를 사용할 때
		ps = c.prepareStatement("insert into myuser(id, name, pass) values(?,?,?)");
		ps.setString(1, user.getId());
		ps.setString(2, user.getName());
		ps.setString(3, user.getPass());
		ps.executeUpdate();
		ps.close();	
	}
	
	public UserVO get(String id) throws ClassNotFoundException, SQLException{	
		//c = connectionMaker.makeConnection(); //CountingDaoFactory.realConnectionMaker 메소드가 리턴하는 클래스의 makeConnection()을 의미함		
		Connection c = dataSource.getConnection();	//dataSource 인터페이스를 사용할 때
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
