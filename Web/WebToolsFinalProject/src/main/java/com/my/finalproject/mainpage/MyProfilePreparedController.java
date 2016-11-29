package com.my.finalproject.mainpage;

import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.my.finalproject.DAO.TeachersDAO;
import com.my.finalproject.model.Teachers;
import com.my.finalproject.model.User;

@Controller
public class MyProfilePreparedController {

	@Autowired
	TeachersDAO teacherdao;
	
	@RequestMapping(value ="/teacher",method=RequestMethod.POST)
	@ResponseBody
	
	public Teachers populateMyprofile(HttpServletRequest request) throws Exception{
		try{
			User user = (User) request.getSession().getAttribute("user");
			System.out.println(user.getUsername());
			Teachers teacher = new Teachers();
			ArrayList<Teachers> list = teacherdao.populateTeachers();
			for(int i=0;i<list.size();i++){
				if(user.getUsername().equalsIgnoreCase(list.get(i).getUsername())){
					teacher = list.get(i);
				}
			}
			return teacher;
			
		}catch(Exception e){
			throw new Exception("Couldn't populate teacher");
		}
	}
}
