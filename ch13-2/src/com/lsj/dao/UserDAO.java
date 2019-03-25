package com.lsj.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.lsj.model.UserVO;


public class UserDAO{
	private ConnectionMaker connectionMaker;
	private PreparedStatement ps; 
	
	public UserDAO() {
		connectionMaker = new NConnectionMaker(); 
	}
	
	public UserDAO(ConnectionMaker connectionMaker) {
		this.connectionMaker = connectionMaker;
	}
	
	public void add(UserVO user) throws ClassNotFoundException, SQLException{	
		Connection c = connectionMaker.makeConnection();
		ps = c.prepareStatement("insert into myuser(id, name, pass) values(?,?,?)");
		ps.setString(1, user.getId());
		ps.setString(2, user.getName());
		ps.setString(3, user.getPass());
		ps.executeUpdate();
		ps.close();	
	}
	
	public UserVO get(String id) throws ClassNotFoundException, SQLException{	
		Connection c = connectionMaker.makeConnection();
		ps = c.prepareStatement("select * from myuser where id = ?");
		ps.setString(1, id);
		ResultSet rs = ps.executeQuery();
		rs.next();
		
		UserVO user = new UserVO();
		user.setId(rs.getString("id"));
		user.setName(rs.getString("name"));
		user.setPass(rs.getString("pass"));
		
		rs.close();
		ps.close();
		
		return user;
	}


	
}
