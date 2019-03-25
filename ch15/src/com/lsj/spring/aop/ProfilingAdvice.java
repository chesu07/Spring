package com.lsj.spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;

//Advice 클래스 
public class ProfilingAdvice {
	//applicationContextOne.xml 에서 호출
	public Object trace(ProceedingJoinPoint joinPoint) throws Throwable{
		String signatureString = joinPoint.getSignature().toShortString();
		long start = System.currentTimeMillis();
		
		System.out.println(signatureString + " 시작");
		
		try{
			Object result = joinPoint.proceed();
			return result;		
			
		} finally{
			long finish = System.currentTimeMillis();
			System.out.println(signatureString + " 종료");
			System.out.println(signatureString + " 실행시간 : " + (finish - start) + "ms");
		}		
	}
}
