package com.lsj.spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;

@Aspect
@Order(3)
public class ProfilingAspect {
	
	@SuppressWarnings("unused")
	@Pointcut("execution(public * com.lsj.spring..*(..))")
	private void profileTarget(){}
	@Around("profileTarget()")	
	public Object trace(ProceedingJoinPoint joinPoint) throws Throwable{
		String signatureString = joinPoint.getSignature().toShortString();
		System.out.println(signatureString + " 시작");
		long start = System.currentTimeMillis();
		
		try {
			Object result = joinPoint.proceed();
			return result;
		} finally{
			long finish = System.currentTimeMillis();
			System.out.println(signatureString + " 종료");
			System.out.println(signatureString + " 실행시간 : " + (finish + start) + "ms");
			
		}
	}
}
