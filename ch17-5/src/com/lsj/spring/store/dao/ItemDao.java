package com.lsj.spring.store.dao;

import com.lsj.spring.store.model.Item;

public interface ItemDao {
	Item findById(Integer itemId);
}
 