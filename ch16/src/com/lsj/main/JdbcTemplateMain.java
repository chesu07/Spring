package com.lsj.main;

import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lsj.spring.dao.JdbcTemplateGuestMessageDao;
import com.lsj.spring.model.GuestMessage;

public class JdbcTemplateMain {
	
	private GuestMessage makeGuestMessage(String guestName, String message){
		GuestMessage msg = new GuestMessage();
		msg.setGuestName(guestName);
		msg.setMessage(message);
		msg.setRegistryDate(new Date());
		return msg;
	}
	
	public static void main(String[] args){
		try{
			String[] configLocations = new String[] { "applicationContext.xml" };
			ApplicationContext context = new ClassPathXmlApplicationContext(configLocations);
			
			JdbcTemplateGuestMessageDao dao = (JdbcTemplateGuestMessageDao) context.getBean("jdbcTemplateGuestMessageDao");
			
			JdbcTemplateMain myTest = new JdbcTemplateMain();
			
			/*
			//INSERT
			dao.insert(myTest.makeGuestMessage("작성자1", "게시물 제목1"));
			dao.insert(myTest.makeGuestMessage("작성자2", "게시물 제목2"));
			dao.insert(myTest.makeGuestMessage("작성자3", "게시물 제목3"));
			*/
			
			
			/*
			//UPDATE
			GuestMessage msg2 = new GuestMessage();
			msg2.setMessage("게시물 제목1_UPDATE");
			msg2.setId(2);
			
			dao.update(msg2);
			dao.update(msg2);
			dao.update(msg2);
			*/
			
			
			//DELETE
			//dao.delete(7);
					
			
			int count = dao.count();			
			List<GuestMessage> list = dao.select(1, count);
			for(GuestMessage msg : list){
				System.out.println(msg.getId() + ": " + msg.getGuestName() + ": " + msg.getMessage() + ": " + msg.getRegistryDate() );
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}				
	}
	
}
