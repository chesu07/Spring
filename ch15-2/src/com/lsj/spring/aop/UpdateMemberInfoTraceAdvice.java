package com.lsj.spring.aop;

import org.aspectj.lang.JoinPoint;

import com.lsj.spring.member.service.UpdateInfo;

//파라미터 접근 실습용 추적정보를 제공할 Advice클래스
public class UpdateMemberInfoTraceAdvice {
	public void traceReturn(JoinPoint joinPoint, boolean result, String memberId, UpdateInfo info){
		System.out.println("[TA] 정보 수정: 결과="+ result + ",대상회원=" + memberId + ",수정정보=" + info);
	}
}
