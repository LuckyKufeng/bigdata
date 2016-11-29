package com.my.finalproject.fileController;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.my.finalproject.DAO.FileDAO;
import com.my.finalproject.model.User;


@Controller
public class FilePopulateController {
	
	@Autowired
	FileDAO filedao;
	
	@RequestMapping(value="/populatefile",method=RequestMethod.POST)
	@ResponseBody
	public ArrayList<String> populateFiles(HttpServletRequest request){
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		String name = user.getUsername();
		ArrayList<String> files = new ArrayList<String>();
		try{
			files = (ArrayList<String>) filedao.getFiles(name);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		return files;
	}

}
