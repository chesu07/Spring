package com.lsj.main;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.lsj.spring.MyBean;
import com.lsj.spring.MyMsgBean;

public class MyBeanMain {
	public static void main(String[] args) {
		try {
			Resource resource = new ClassPathResource("applicationContext.xml");
			BeanFactory factory = new XmlBeanFactory(resource);
			//MyBean bean = (MyBean) factory.getBean("myBean");
			MyMsgBean bean = (MyMsgBean) factory.getBean("myMsgBean");
			bean.sayHello();	
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
