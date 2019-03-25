package com.lsj.spring.aop;

//Before, After Throwing, After Advice 실습용 Logging 서비스를 제공할 Advice클래스
public class LoggingAdvice {
	public void before(){
		System.out.println("[LA] 메서드 실행 전 전처리 수행");
	}
	public void afterReturning(Object ret){
		System.out.println("[LA] 메서드 실행 후 후처리 수행(" + ret.getClass().getName() + "), 리턴값=" + ret);
	}
	public void afterThrowing(Throwable ex){
		System.out.println("[LA] 메서드 실행 중 예외발생, 예외=" + ex.getClass().getName());
	}
	//try-catch 의 finally와 같음 무조건 수행함
	public void afterFinally(){
		System.out.println("[LA] 메서드 실행 완료");
	}
}
