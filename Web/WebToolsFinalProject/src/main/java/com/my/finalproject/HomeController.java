package com.my.finalproject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	
	@RequestMapping(value="/")
	public String home(){
		return "homepage";
	}
	@RequestMapping(value="/homepage")
	public String goBackHomepage(){
		return "homepage";
	}
	
}
