package com.lsj.spring.service;

import com.lsj.spring.common.CommonLogger;

//인증 클래스
public class MockAuthenticator implements Authenticator{
	private CommonLogger commonLogger;
	
	@Override
	public void authenticate(LoginCommand loginCommand) throws AuthenticationException{
		System.out.println("authenticate");
		if(!loginCommand.getUserId().equals(loginCommand.getPassword())){
			commonLogger.log("인증 에러 : " + loginCommand.getUserId());
			throw new AuthenticationException();
		}
	}
	
	public void setCommonLogger(CommonLogger commonLogger){
		System.out.println("setCommonLogger");
		this.commonLogger = commonLogger;
	}
}
