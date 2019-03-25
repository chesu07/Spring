package com.lsj.spring.service;

import com.lsj.spring.model.GuestMessage;
import com.lsj.spring.model.GuestMessageList;

public interface GuestMessageService {
	GuestMessage write(GuestMessage message);
	GuestMessageList getMessageList(int pageNum);
}
