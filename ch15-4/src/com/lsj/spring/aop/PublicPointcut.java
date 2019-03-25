package com.lsj.spring.aop;

import org.aspectj.lang.annotation.Pointcut;

//Pointcut 클래스 작성
public class PublicPointcut {
	@Pointcut("execution(public * com.lsj.spring..*(..))")
	public void publicMethod(){}
}
