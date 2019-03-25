package com.lsj.stepthree;

public class MyBeanTwo implements MyBean{
	@Override
	public void sayHello(String name){
		System.out.println("MyBeanTwo: " + name + "!");
	}
}
