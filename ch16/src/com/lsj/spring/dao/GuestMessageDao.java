package com.lsj.spring.dao;

import java.util.List;

import com.lsj.spring.model.GuestMessage;

//DAO 기능을 추상화한 인터페이스
public interface GuestMessageDao {
	public int count();
	public List<GuestMessage> select(int begin, int end);
	public int insert(GuestMessage message);
	public int delete(int id);
	public int update(GuestMessage message);	
}
