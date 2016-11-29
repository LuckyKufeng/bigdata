package com.my.finalproject.Community;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class CommunityController {
		
		@RequestMapping(value="/community")
		public String goCommunity(){
			return "community";
		}
}
