package com.mycompany.api.customer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myapp.core.catalog.beans.LoginData;

@Controller
public class RestLoginController 
{
	@RequestMapping("/**/rlogin")
	public void login(LoginData loginData)
	{
		
	}
}
