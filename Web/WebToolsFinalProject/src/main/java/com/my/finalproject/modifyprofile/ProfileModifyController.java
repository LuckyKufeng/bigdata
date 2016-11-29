package com.my.finalproject.modifyprofile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.my.finalproject.DAO.ModifyUserDAO;
import com.my.finalproject.model.User;

@Controller
public class ProfileModifyController {
	
	@Autowired
	ModifyUserDAO modifyuserdao;
	
	@RequestMapping(value="/modifyprofile",method=RequestMethod.POST)
	public String save(HttpServletRequest request,@RequestParam("name")String name, @RequestParam("officeinfo") String officeinfo){
		try{
			HttpSession session = request.getSession();
			User user = (User) session.getAttribute("user");
			String username = user.getUsername();
			if(user != null){
				System.out.println(user.getUsername());
			}
			modifyuserdao.updataTeacher(username, name, officeinfo);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return "mainpage";
	}
}
