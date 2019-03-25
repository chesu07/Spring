package com.lsj.spring.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lsj.spring.board.service.WriteArticleService;
import com.lsj.spring.member.service.MemberService;
import com.lsj.spring.model.Article;
import com.lsj.spring.model.Member;

public class MainSchema {
	public static void main(String[] args) {
		String[] configLocations = new String[] {"applicationContext.xml"};
		ApplicationContext context = new ClassPathXmlApplicationContext(configLocations);
		WriteArticleService articleService = (WriteArticleService) context.getBean("writeArticleService");		
		articleService.write(new Article());
		MemberService memberService = context.getBean("memberService", MemberService.class);
		memberService.regist(new Member());
	}
}
