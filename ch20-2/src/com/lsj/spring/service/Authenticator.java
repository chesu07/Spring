package com.lsj.spring.service;

import javax.naming.AuthenticationException;

public interface Authenticator {
	void authenticate(LoginCommand loginCommand) throws AuthenticationException;
}
