package com.lsj.spring.store.dao.mybatis;

import org.mybatis.spring.SqlSessionTemplate;

import com.lsj.spring.store.dao.ItemDao;
import com.lsj.spring.store.model.Item;

public class MyBatisItemDao implements ItemDao {
	private SqlSessionTemplate sqlSession;
	
	public void setSqlSession(SqlSessionTemplate sqlSession){
		this.sqlSession = sqlSession;
	}
	
	@Override 
	public Item findById(Integer itemId){
		String statement = "com.lsj.spring.dao.mybatis.Item.findById";
		return (Item) sqlSession.selectOne(statement, itemId);
	} 
}
