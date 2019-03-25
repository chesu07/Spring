package com.lsj.spring;

import java.io.IOException;

public class MyMsgBeanImpl implements MyMsgBean{
	private String name;
	private String greeting;
	private Outputter outputter;
	
	public MyMsgBeanImpl(String name){
		super();
		this.name = name;
	}
	
	@Override
	public void sayHello(){
		String msg = greeting + name;
		System.out.println(msg);
		
		try{ 
			outputter.output(msg);
		}catch (IOException ioe) {
			ioe.printStackTrace();
		}	
	}
	
	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}
	
	public void setOutputter(Outputter outputter) {
		this.outputter = outputter;
	}

	@Override
	public void output(String msg) throws IOException {	
		
	}
	
}
