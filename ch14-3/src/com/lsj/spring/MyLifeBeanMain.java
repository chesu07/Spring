package com.lsj.spring;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class MyLifeBeanMain {
	public static void main(String[] args) {		
		org.springframework.context.ApplicationContext factory = new FileSystemXmlApplicationContext("src/applicationContext.xml");
		MyLifeBean bean = (MyLifeBean) factory.getBean("myLifeBean");
		bean.sayHello();
		
	}
}
