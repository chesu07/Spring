package com.lsj.spring.service;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.lsj.spring.dao.GuestMessageDao;
import com.lsj.spring.model.GuestMessage;
import com.lsj.spring.model.GuestMessageList;

public class GuestMessageServiceImpl implements GuestMessageService{
	public static final int DEFAULT_PAGE_SIZE = 20;
	private int pageSize = DEFAULT_PAGE_SIZE;
	private GuestMessageDao guestMessageDao;
	
	@Transactional
	public GuestMessage write(GuestMessage message){
		message.setRegistryDate(new Date());
		guestMessageDao.insert(message);
		return message;
	}
	
	@Transactional
	public GuestMessageList getMessageList(int pageNum){
		int totalCount = guestMessageDao.count();	// ¹«Á¶°Ç 0
		if(totalCount == 0){
			return new GuestMessageList(0, 0, 0, 0, Collections.<GuestMessage> emptyList());
		}
		
		int begin = (pageNum -1) * pageSize + 1;
		int end = pageNum * pageSize;
		if(end > totalCount) end = totalCount;
		
		List<GuestMessage> messages = guestMessageDao.select(begin, end);
		return new GuestMessageList(totalCount, pageNum, begin, end, messages);
	}
	
	@Autowired
	public void setGuestMessageDao(GuestMessageDao guestMessageDao){
		this.guestMessageDao = guestMessageDao;
	}
}
