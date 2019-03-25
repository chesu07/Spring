package com.lsj.model;

public class UserVO {
	private String id;
	private String name;
	private String pass;
	
	//getter
	public String getId(){
		return this.id;
	}
	public String getName(){
		return this.name;
	}
	public String getPass(){
		return this.pass;
	}
	
	//setter
	public void setId(String s){
		this.id = s;
	}
	public void setName(String s){
		this.name = s;
	}
	public void setPass(String s){
		this.pass = s;
	}
	
	
}
