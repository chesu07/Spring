package com.lsj.spring.common;

//로깅 구현 클래스
public class CommonLoggerImpl implements CommonLogger{
	@Override
	public void log(String message){
		System.out.println("CommonLogger : " + message);
	}
}
