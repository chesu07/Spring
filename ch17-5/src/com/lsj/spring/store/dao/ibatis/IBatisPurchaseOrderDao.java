package com.lsj.spring.store.dao.ibatis;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.lsj.spring.store.dao.PurchaseOrderDao;
import com.lsj.spring.store.model.PurchaseOrder;

public class IBatisPurchaseOrderDao extends SqlMapClientDaoSupport implements PurchaseOrderDao{
	public int nextVal(){
		return (Integer) getSqlMapClientTemplate().queryForObject("PurchaseOrder.nextVal");
	} 
	
	@Override
	public void insert(PurchaseOrder order){
		order.setId(nextVal());
		getSqlMapClientTemplate().insert("PurchaseOrder.insert", order);
	}

} 
