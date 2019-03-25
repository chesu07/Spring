package com.lsj.stepthree;

public class MyBeanOne implements MyBean{
	@Override
	public void sayHello(String name){
		System.out.println("MyBeanOne: " + name + "!");
	}
}
