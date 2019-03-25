package com.lsj.spring.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;

//어노테이션을 이용한 Aspect 클래스 작성
@Aspect
@Order(1)
public class LoggingAspect {
	@Before("PublicPointcut.publicMethod()")
	public void before(){
		System.out.println("[LA] 메서드 실행전 전처리 수행");
	}
	
	@AfterReturning(pointcut = "com.lsj.spring.aop.PublicPointcut.publicMethod()", returning = "ret")
	public void afterReturning(Object ret) {
		System.out.println("[LA] 메서드 실행후 후처리 수행, 리턴값=" + ret);
	}
	
	@AfterThrowing(pointcut = "com.lsj.spring.aop.PublicPointcut.publicMethod()", throwing = "ex")
	public void afterThrowing(Throwable ex) {
		System.out.println("[LA] 메서드 실행중 예외 발생, 예외=" + ex.getClass().getName());
	}
	
	@After("com.lsj.spring.aop.PublicPointcut.publicMethod()")
	public void afterFamily(){
		System.out.println("[LA] 메서드 실행완료");
	}
}
