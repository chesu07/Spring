package com.lsj.spring.store.dao.mybatis;

import org.mybatis.spring.SqlSessionTemplate;

import com.lsj.spring.store.dao.PurchaseOrderDao;
import com.lsj.spring.store.model.PurchaseOrder;

public class MyBatisPurchaseOrderDao implements PurchaseOrderDao {
private SqlSessionTemplate sqlSession;
	
	public void setSqlSession(SqlSessionTemplate sqlSession){
		this.sqlSession = sqlSession;
	}
	
	public int nextVal(){
		String statement = "com.lsj.spring.dao.mybatis.PurchaseOrder.nextVal";
		return (Integer) sqlSession.selectOne(statement);				
	}
	
	@Override
	public void insert(PurchaseOrder order) {
		order.setId(nextVal());
		String statement = "com.lsj.spring.dao.mybatis.PurchaseOrder.insert";
		sqlSession.insert(statement, order);
	}
}
