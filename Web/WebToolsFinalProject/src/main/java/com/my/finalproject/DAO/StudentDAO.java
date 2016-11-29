package com.my.finalproject.DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;

import com.my.finalproject.model.Student;

public class StudentDAO extends DAO {

	public ArrayList<Student> listStudent() throws Exception{
		try{
			Query query = getSession().createQuery("from Student");
			ArrayList<Student> list = (ArrayList<Student>) query.list();
			return list;
		}catch(Exception e){
			throw new Exception("Can't find student!");
		}
		
	}
}
