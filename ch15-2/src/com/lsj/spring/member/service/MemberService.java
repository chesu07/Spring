package com.lsj.spring.member.service;

import com.lsj.spring.model.Member;

public interface MemberService {
	void regist(Member member);
	boolean update(String memberId, UpdateInfo info);
}
