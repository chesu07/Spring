package com.lsj.spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.lsj.spring.model.GuestMessage;

//목록조회시 사용할 RowMapper 클래스
public class GuestMessageRowMapper implements RowMapper<GuestMessage>{
	@Override
	public GuestMessage mapRow(ResultSet rs, int rowNum) throws SQLException{
		GuestMessage message = new GuestMessage();
		message.setId(rs.getInt("MESSAGE_ID"));
		message.setGuestName(rs.getString("GUEST_NAME"));
		message.setMessage(rs.getString("MESSAGE"));
		message.setRegistryDate(rs.getDate("REGISTRY_DATE"));
		return message;
	}
}
