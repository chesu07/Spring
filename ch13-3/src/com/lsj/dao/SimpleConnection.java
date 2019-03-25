package com.lsj.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SimpleConnection {
	public Connection makeNewConnection() throws ClassNotFoundException, SQLException{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:DHDB", "scott", "snrnrh21");
		System.out.println("DB에 연결되었습니다.");
		return c;
	}
}
