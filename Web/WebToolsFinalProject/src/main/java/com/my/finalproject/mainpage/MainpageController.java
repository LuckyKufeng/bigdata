package com.my.finalproject.mainpage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class MainpageController {
	
	@RequestMapping(value="/admin")
	public String mainpage(){
		//admin role go mainpage;
		return "mainpage";
	}

}