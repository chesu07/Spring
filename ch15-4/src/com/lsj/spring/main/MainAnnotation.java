package com.lsj.spring.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lsj.spring.board.service.ReadArticleService;
import com.lsj.spring.member.service.ArticleNotFoundException;
import com.lsj.spring.member.service.MemberService;
import com.lsj.spring.member.service.UpdateInfo;
import com.lsj.spring.model.Article;

public class MainAnnotation {
	public static void main(String[] args) {
		String[] configLocations = new String[] { "applicationContextAnnotation.xml" };
		ApplicationContext context = new ClassPathXmlApplicationContext(configLocations);
		ReadArticleService readArticleService = context.getBean("readArticleService", ReadArticleService.class);
		
		try {
			Article article1 = readArticleService.getArticleAndIncreaseReadCount(1);
			Article article2 = readArticleService.getArticleAndIncreaseReadCount(1);
			System.out.println("article 1 == article2 : " + (article1 == article2));
			readArticleService.getArticleAndIncreaseReadCount(0);
			
		} catch (ArticleNotFoundException e) {
			System.out.println("ArticleNotFoundException");
			MemberService memberService = context.getBean("memberService", MemberService.class);
			memberService.update("½Å´ëÈ«", new UpdateInfo());
		}
	}
}
