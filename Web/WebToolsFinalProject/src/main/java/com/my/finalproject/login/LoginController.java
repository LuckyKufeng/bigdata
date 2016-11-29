package com.my.finalproject.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.my.finalproject.DAO.UserDAO;
import com.my.finalproject.model.User;

@Controller
public class LoginController {
	
	@Autowired
	UserDAO userdao;
	
	//login controller method
	@RequestMapping(value = "/userlogin", method = RequestMethod.POST)
	public String home(Model model,HttpServletRequest request,HttpServletResponse respond ) {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		try {
			User user = userdao.authUser(username, password);
			if(user != null){ // if has a role will go to mainpage
				setRole(request,user.getRole());
				setUser(request, user);
				return "mainpage";	
			}else{
				populateErrorMessage(model);
				return "login";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "login";
	}
	
	//store user role in the session
	public void setRole(HttpServletRequest request,String role){
		HttpSession session = request.getSession();
		session.setAttribute("role", role);
	}
	
	public void populateErrorMessage(Model model){
		String error = "Not find User";
		model.addAttribute("error",error);
	}
	
	//store username
	public void setUser(HttpServletRequest request,User user){
		HttpSession session = request.getSession();
		session.setAttribute("user", user);
	}
	
}
