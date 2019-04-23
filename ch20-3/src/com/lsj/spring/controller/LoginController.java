package com.lsj.spring.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lsj.spring.common.CommonLogger;
import com.lsj.spring.service.AuthenticationException;
import com.lsj.spring.service.Authenticator;
import com.lsj.spring.service.LoginCommand;
import com.lsj.spring.validation.LoginCommandValidator;

@Controller
@RequestMapping("/login/login.do")
public class LoginController {
	private String formViewName = "login/form";
	
	@Autowired
	private Authenticator authenticator;
	
	@RequestMapping(method = RequestMethod.GET)
	public String form(){
		System.out.println("form");
		return formViewName;
	}
	
	@ModelAttribute
	public LoginCommand formBacking(){
		System.out.println("formBacking");
		return new LoginCommand();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String submit(@Valid LoginCommand loginCommand, BindingResult result){
		System.out.println("submit");
		
		if(result.hasErrors()){
			return formViewName;
		}
		try{
			authenticator.authenticate(loginCommand);
			//로그인 성공
			return "redirect:/index.jsp";
		}catch(AuthenticationException e){
			//validation.properties 의 invalidIdOrPassword.loginCommand 설정값
			result.reject("invalidIdOrPassword", new Object[] { loginCommand.getUserId() }, null);
			return formViewName;
		}		
	}
	
	@InitBinder
	protected void initBinder(WebDataBinder binder){
		System.out.println("initBinder");
		binder.setValidator(new LoginCommandValidator());
	}
	
	public void setAuthenticator(Authenticator loginService){
		System.out.println("setAuthenticator");
		this.authenticator = loginService;
	}
}
