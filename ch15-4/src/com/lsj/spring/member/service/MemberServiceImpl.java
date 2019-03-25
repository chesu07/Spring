package com.lsj.spring.member.service;

import com.lsj.spring.model.Member;

public class MemberServiceImpl implements MemberService{
	@Override
	public void regist(Member member){
		System.out.println("MemberServiceImpl.regist() 실행");
	}
	
	@Override
	public boolean update(String memberId, UpdateInfo info){
		System.out.println("MemberServiceImpl.update() 실행");
		return true;		
	}  
}
