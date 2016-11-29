package com.my.finalproject.classes;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.my.finalproject.DAO.ClasstableDAO;
import com.my.finalproject.model.Classtable;

@Controller
public class ClassDataController {

	@Autowired 
	ClasstableDAO classtabledao;
	
	@RequestMapping(value="/classes",method=RequestMethod.POST)
	@ResponseBody
	public ArrayList<Classtable> populateClasses(){
		ArrayList<Classtable> list = new ArrayList<Classtable>();
		try{
			list = classtabledao.populateClass();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
	
}
