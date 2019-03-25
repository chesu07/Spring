package com.lsj.spring.dao;

import java.sql.Types;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

import com.lsj.spring.model.GuestMessage;

public class SimpleJdbcGuestMessageDao implements GuestMessageDao{
	private SimpleJdbcTemplate template;
	private SimpleJdbcInsert insertMessage;
	
	public SimpleJdbcGuestMessageDao(DataSource dataSource){
		template = new SimpleJdbcTemplate(dataSource);
		insertMessage = new SimpleJdbcInsert(dataSource);
		insertMessage.withTableName("GUESTBOOK_MESSAGE")
		.usingColumns("MESSAGE_ID", "GUEST_NAME", "MESSAGE", "REGISTRY_DATE");
		 
	}
 
	public int nextVal(){
		return template.queryForObject("select guest_seq.nextval from dual", Integer.class);
	}
	
	@Override
	public int count(){
		return template.queryForObject("select count(1) from GUESTBOOK_MESSAGE", Integer.class);
	}
	
	@Override
	public int delete(int id){
		return template.update("delete from GUESTBOOK_MESSAGE where MESSAGE_ID = ?", id);
	}
	
	@Override
	public int insert(GuestMessage message){
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		message.setId(nextVal());
		paramSource.addValue("MESSAGE_ID", message.getId());
		paramSource.addValue("GUEST_NAME", message.getGuestName());
		paramSource.addValue("MESSAGE", message.getMessage());
		paramSource.addValue("REGISTRY_DATE", message.getRegistryDate());
		
		return insertMessage.execute(paramSource);		
		
	}
	
	@Override
	public List<GuestMessage> select(int begin, int end){
		int startRowNum = begin;
		int count = end - begin + 1;
		
		return template.query("select * from (select ROWNUM rnum, MESSAGE_ID, GUEST_NAME, MESSAGE, REGISTRRY_DATE from (select  * from GUESTBOOK_MESSAGE order by MESSAGE_ID deesc)) where rnum> >= :startRowNum and rnum <= :count", new GuestMessageRowMapper(), startRowNum, count);				
	}
	
	@Override
	public int update(GuestMessage message){
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("message", message.getMessage());
		paramSource.addValue("id", message.getId(), Types.INTEGER);
		return template.update("update GUESTBOOK_MEESAGE set MESSAGE = :message where MESSAGE_ID = :id", paramSource);
		
	}
	
}
