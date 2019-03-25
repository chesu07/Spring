package com.lsj.spring.dao;

import java.sql.Types;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.lsj.spring.model.GuestMessage;

//GuestMessageDao를 상속받아서 실제적인 DAO 내용을 구현하는 클래스
public class JdbcTemplateGuestMessageDao implements GuestMessageDao{
	private JdbcTemplate jdbcTemplate;
	
	public JdbcTemplateGuestMessageDao(DataSource dataSource){
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public int count(){
		//스프링3.2 버전부터 queryForInt 삭제되었음. queryForObject 사용할 것 
		return jdbcTemplate.queryForObject("select count(1) from GUESTBOOK_MESSAGE", Integer.class);		
	}
	
	@Override
	public int delete(int id){
		return jdbcTemplate.update("delete from GUESTBOOK_MESSAGE where message_id = ?", id);
	}
	
	@Override
	public int insert(final GuestMessage message){
		int insertedCount = jdbcTemplate.update("insert into GUESTBOOK_MESSAGE(MESSAGE_ID, GUEST_NAME, MESSAGE, REGISTRY_DATE) values(GUEST_SEQ.NEXTVAL, ?, ?, ?)", message.getGuestName(), message.getMessage(), message.getRegistryDate());
		return insertedCount;
	}
	
	@Override
	public List<GuestMessage> select(int begin, int end){
		return jdbcTemplate.query("select * from (select ROWNUM rnum, MESSAGE_ID, GUEST_NAME, MESSAGE, REGISTRY_DATE from (select * from GUESTBOOK_MESSAGE order by MESSAGE_ID desc)) where rnum >= ? and rnum <= ?", new Object[] { begin, end }, new GuestMessageRowMapper());
	}
	
	@Override
	public int update(GuestMessage message){
		return jdbcTemplate.update("update GUESTBOOK_MESSAGE set MESSAGE = ? where MESSAGE_ID = ?", new Object[] { message.getMessage(), message.getId() }, new int[] { Types.VARCHAR, Types.INTEGER } );		
	}
	
}
