package com.lsj.model;

import java.sql.SQLException;

import javax.sql.DataSource;

public interface BoardDAO {
	//DAO에 필요한 추상메소드 선언
	void insert(BoardVO vo) throws ClassNotFoundException, SQLException;
	
	void setDataSource(DataSource dataSource);	
}
