package com.lsj.impl;

import java.sql.Connection;
import java.sql.SQLException;

//DB 커넥션을 제공하는 인터페이스
public interface ConnectionMaker {
	public abstract Connection makeConnection() throws ClassNotFoundException, SQLException;	
}
