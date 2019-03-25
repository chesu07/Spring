package com.lsj.spring.model;

public class Article {
	private int id;
	private Article articleDAO;
	public Article() {
		
	}
	//getter, setter
	public int getId() {
		return id;
	}
	public Article getArticleDAO() {
		return articleDAO;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setArticleDAO(Article articleDAO) {
		this.articleDAO = articleDAO;
	}
}
