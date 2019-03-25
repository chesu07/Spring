package com.lsj.spring.store.dao.mybatis;

import org.mybatis.spring.SqlSessionTemplate;

import com.lsj.spring.store.dao.PaymentInfoDao;
import com.lsj.spring.store.model.PaymentInfo;

public class MyBatisPaymentInfoDao implements PaymentInfoDao{
	private SqlSessionTemplate sqlSession;
	
	public void setSqlSession(SqlSessionTemplate sqlSession){
		this.sqlSession = sqlSession;
	}
	
	public int nextVal(){
		String statement = "com.lsj.spring.dao.mybatis.PaymentInfo.nextVal";
		return (Integer) sqlSession.selectOne(statement);				
	}
	
	@Override
	public void insert(PaymentInfo paymentInfo) {
		paymentInfo.setId(nextVal());
		String statement = "com.lsj.spring.dao.mybatis.PaymentInfo.insert";
		sqlSession.insert(statement, paymentInfo);
	}
}
