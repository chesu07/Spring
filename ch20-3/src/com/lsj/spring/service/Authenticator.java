package com.lsj.spring.service;

//인증 인터페이스
public interface Authenticator {
	void authenticate(LoginCommand loginCommand) throws AuthenticationException;
}
