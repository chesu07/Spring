package com.lsj.spring.board.service;

import com.lsj.spring.model.Article;
import com.lsj.spring.model.ArticleDAO;

public class WriteArticleServiceImpl implements WriteArticleService{
	private ArticleDAO articleDao;
	
	public WriteArticleServiceImpl(){
		
	}
	
	public WriteArticleServiceImpl(ArticleDAO articleDao){
		this.articleDao = articleDao;
	}
	
	@Override
	public void write(Article article){
		System.out.println("WriteArticleServiceImpl.write() 실행");
		articleDao.insert(article);	
	}
}