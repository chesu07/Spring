package com.lsj.spring.store.dao.ibatis;

import org.springframework.orm.ibatis.SqlMapClientTemplate;

import com.lsj.spring.store.dao.ItemDao;
import com.lsj.spring.store.model.Item;

public class IBatisItemDao implements ItemDao{
	private SqlMapClientTemplate sqlMapClientTemplate;
	
	public void setSqlMapClientTemplate(SqlMapClientTemplate sqlMapClientTemplate){
		this.sqlMapClientTemplate = sqlMapClientTemplate;
	}
	
	@Override 
	public Item findById(Integer itemId){
		return (Item) sqlMapClientTemplate.queryForObject("Item.findById", itemId);
	} 
}
