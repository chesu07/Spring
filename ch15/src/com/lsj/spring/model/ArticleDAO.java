package com.lsj.spring.model;

public interface ArticleDAO {
	void insert(Article article);
	void updateReadCount(int id, int i);	
}
