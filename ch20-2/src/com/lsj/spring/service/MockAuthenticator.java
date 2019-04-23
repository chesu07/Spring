package com.lsj.spring.service;

import javax.naming.AuthenticationException;

import com.lsj.spring.common.CommonLogger;

public class MockAuthenticator implements Authenticator{
	private CommonLogger commonLogger;
	
	@Override
	public void authenticate(LoginCommand loginCommand) throws AuthenticationException{
		if(!loginCommand.getUserId().equals(loginCommand.getPassword())) {
			commonLogger.log("인증에러 - " + loginCommand.getUserId());
			throw new AuthenticationException();
		}
	}
	
	public void setCommonLogger(CommonLogger commonLogger){
		this.commonLogger = commonLogger;
	} 
	
}
