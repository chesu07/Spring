package com.lsj.spring;

import java.io.IOException;

public class MyBeanImpl implements MyMsgBean{
	private String name;
	private String greeting;
	private Outputter outputter;
	
	public MyBeanImpl(String name){
		super();
		this.name = name;
	}
	
	@Override
	public void sayHello(){
		System.out.println(greeting + name);
	}
	
	public String getGreeting(){
		return greeting;
	}
	
	public void setGreeting(String greeting){
		this.greeting = greeting;
	}
	
	public void setOutputter(Outputter outputter) {
		this.outputter = outputter;
	}

	@Override
	public void output(String msg) throws IOException {
	
	}
	
}
