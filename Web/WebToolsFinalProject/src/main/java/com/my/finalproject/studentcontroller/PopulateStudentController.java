package com.my.finalproject.studentcontroller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.my.finalproject.DAO.ClasstableDAO;
import com.my.finalproject.DAO.StudentDAO;
import com.my.finalproject.model.Classtable;
import com.my.finalproject.model.Student;
import com.my.finalproject.modelstore.Mainpagedataprepareobject;



@Controller
public class PopulateStudentController {
	
	@Autowired
	StudentDAO studentdao;
	
	@Autowired
	ClasstableDAO classtabledao;
	
	@RequestMapping(value="/student",method=RequestMethod.POST)
	@ResponseBody
	public ArrayList<Mainpagedataprepareobject> populateStudent(){
		ArrayList<Mainpagedataprepareobject> list = new ArrayList<Mainpagedataprepareobject>();
		ArrayList<Student> studentlist = new ArrayList<Student>();
		ArrayList<Classtable> classlist = new ArrayList<Classtable>();
 		try{
			studentlist = studentdao.listStudent();
			classlist = classtabledao.populateClass();
			
			for(int i=0;i<classlist.size();i++){
				Mainpagedataprepareobject object = new Mainpagedataprepareobject();
				object.setTheclass(classlist.get(i));
				for(int j= 0;j < studentlist.size();j++){
					if(classlist.get(i).getId() == studentlist.get(j).getClassid()){
						object.getStudents().add(studentlist.get(j));
					}
				}
				list.add(object);
			}
 		}catch(Exception e){
			System.out.println(e.getMessage());
		}
 		return list;
	}
	
}
