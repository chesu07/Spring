package com.lsj.spring.store.dao.ibatis;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.lsj.spring.store.dao.PaymentInfoDao;
import com.lsj.spring.store.model.PaymentInfo;

public class IBatisPaymentInfoDao extends SqlMapClientDaoSupport implements PaymentInfoDao{
	public int nextVal(){
		return (Integer) getSqlMapClientTemplate().queryForObject("PaymentInfo.nextVal");				
	}
	@Override
	public void insert(PaymentInfo paymentInfo) {
		paymentInfo.setId(nextVal());
		getSqlMapClientTemplate().insert("PaymentInfo.insert", paymentInfo);
	}
	 
}
 