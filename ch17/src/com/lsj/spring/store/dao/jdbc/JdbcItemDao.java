package com.lsj.spring.store.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.lsj.spring.store.dao.ItemDao;
import com.lsj.spring.store.model.Item;

//DAO인터페이스를 상속받아 실제적인 DB처리를 담당할 구현 클래스
public class JdbcItemDao implements ItemDao{
	private JdbcTemplate jdbcTemplate;
	
	public JdbcItemDao(DataSource dataSource) {
		 jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public Item findById(Integer itemId) {
		return jdbcTemplate.queryForObject("select * from item where item_id = ?", new Object[] { itemId }, new RowMapper<Item>() {
			@Override
			public Item mapRow(ResultSet rs, int row) throws SQLException{
				Item item = new Item();
				item.setId(rs.getInt("ITEM_ID"));
				item.setName(rs.getString("ITEM_NAME"));
				item.setPrice(rs.getInt("PRICE"));
				return item;
			}
		});
	}
}
