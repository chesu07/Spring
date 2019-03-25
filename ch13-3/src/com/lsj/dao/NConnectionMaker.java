package com.lsj.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.lsj.impl.ConnectionMaker;

//N사의 DB연결
public class NConnectionMaker implements ConnectionMaker {
	@Override
	public Connection makeConnection() throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:DHDB", "scott", "snrnrh21");
		System.out.println("[NConnectionMaker] DB에 연결되었습니다.");
		return c;
	}
}
 