package com.lsj.spring.store.dao.jdbc;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import com.lsj.spring.store.dao.PaymentInfoDao;
import com.lsj.spring.store.model.PaymentInfo;

public class JdbcPaymentInfoDao implements PaymentInfoDao{
	private SimpleJdbcInsert insert;
	private JdbcTemplate jdbcTemplate;
	
	public JdbcPaymentInfoDao(DataSource dataSource){
		jdbcTemplate = new JdbcTemplate(dataSource);
		insert = new SimpleJdbcInsert(dataSource).withTableName("PAYMENT_INFO").usingColumns("PAYMENT_INFO_ID", "PRICE");		
	}
	
	public int nextVal(){
		return jdbcTemplate.queryForObject("select payment_seq.nextval from dual", Integer.class);
	}
	
	@Override
	public void insert(PaymentInfo paymentInfo) {
		 Map<String, Object> paramValueMap = new HashMap<String, Object>();
		 
		 paymentInfo.setId(nextVal());
		 paramValueMap.put("PAYMENT_INFO_ID", paymentInfo.getId());
		 paramValueMap.put("PRICE", paymentInfo.getPrice());
		 insert.execute(paramValueMap);
		 
	}
	
}
