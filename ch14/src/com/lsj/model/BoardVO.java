package com.lsj.model;

public class BoardVO {
	private String id;
	private String name;
	private String title;
	
	//getter
	public String getId(){
		return this.id;
	}
	public String getName(){
		return this.name;
	}
	public String getTitle(){
		return this.title; 
	}
	
	
	//setter
	public void setId(String id){
		this.id = id;
	}
	public void setName(String name){
		this.name = name;
	}
	public void setTitle(String title){
		this.title = title;
	}	
	
}
