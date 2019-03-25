package com.lsj.spring.board.service;

import com.lsj.spring.member.service.ArticleNotFoundException;
import com.lsj.spring.model.Article;

//Read 서비스를 구현한 클래스
public class ReadArticleServiceImpl implements ReadArticleService {
	@Override
	public Article getArticleAndIncreaseReadCount(int id) throws ArticleNotFoundException{
		if(id == 0) throw new ArticleNotFoundException();
		return new Article();
	}	
}
