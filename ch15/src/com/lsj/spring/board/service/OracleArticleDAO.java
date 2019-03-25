package com.lsj.spring.board.service;

import com.lsj.spring.model.Article;
import com.lsj.spring.model.ArticleDAO;

public class OracleArticleDAO implements ArticleDAO{
	@Override
	public void insert(Article article){
		System.out.println("OracleArticleDAO.insert() 실행");
	}
	
	@Override
	public void updateReadCount(int article, int inc){
		System.out.println("OracleArticleDAO.updateReadCount 실행");
	} 
}
