package com.lsj.spring;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.lsj.model.BoardDAO;
import com.lsj.model.BoardVO;

public class MyBoardDAO implements BoardDAO{
	private DataSource setDataSource;
	private PreparedStatement ps; 
	
	@Override
	public void setDataSource(DataSource dataSource){
		this.setDataSource = dataSource;		
	}		
	
	@Override
	public void insert(BoardVO vo) throws ClassNotFoundException, SQLException{
		//이곳에 데이터베이스 처리코드를 작성
		Connection c = setDataSource.getConnection();	//dataSource 인터페이스를 사용할 때
		ps = c.prepareStatement("insert into board(id, name, title) values(?,?,?)");		
		ps.setString(1, vo.getId());
		ps.setString(2, vo.getName());
		ps.setString(3, vo.getTitle());		
		ps.executeUpdate();
		ps.close();	
		
		System.out.println("[아이디] " + vo.getId());
		System.out.println("[이름] " + vo.getName());
		System.out.println("[제목] " + vo.getTitle());
		System.out.println("MyBoardDAO.insert() 완료");
		
	}	
	
	
}
