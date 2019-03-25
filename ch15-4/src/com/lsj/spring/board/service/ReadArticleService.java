package com.lsj.spring.board.service;

import com.lsj.spring.member.service.ArticleNotFoundException;
import com.lsj.spring.model.Article;

//Read 서비스를 제공할 인터페이스
public interface ReadArticleService {
	Article getArticleAndIncreaseReadCount(int id) throws ArticleNotFoundException; 
}
