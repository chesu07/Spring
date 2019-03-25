package com.lsj.spring.store.dao.jdbc;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import com.lsj.spring.store.dao.PurchaseOrderDao;
import com.lsj.spring.store.model.PurchaseOrder;

public class JdbcPurchaseOrderDao implements PurchaseOrderDao{	
	private SimpleJdbcInsert insert;
	private JdbcTemplate jdbcTemplate;
	
	public JdbcPurchaseOrderDao(DataSource dataSource){
		jdbcTemplate = new JdbcTemplate(dataSource);
		insert = new SimpleJdbcInsert(dataSource).withTableName("PURCHASE_ORDER").usingColumns("PURCHASE_ORDER_ID", "ITEM_ID", "PAYMENT_INFO_ID", "ADDRESS");	
	}
	
	public int nextVal(){
		return jdbcTemplate.queryForObject("select purchase_seq.nextval from dual", Integer.class);		
	}
	
	@Override
	public void insert(PurchaseOrder order){
		Map<String, Object> args = new HashMap<String, Object>();
		order.setId(nextVal());
		args.put("PURCHASE_ORDER_ID", order.getId());
		args.put("ITEM_ID", order.getItemId());
		args.put("PAYMENT_INFO_ID", order.getPaymentInfoId());
		args.put("ADDRESS", order.getAddress());
		insert.execute(args);
	}

}
