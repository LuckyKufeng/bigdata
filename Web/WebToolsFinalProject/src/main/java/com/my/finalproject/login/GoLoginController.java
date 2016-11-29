package com.my.finalproject.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GoLoginController {
	
	@RequestMapping(value = "/login")
	public String gologinpage(){
		return "login";
	}
	
}
