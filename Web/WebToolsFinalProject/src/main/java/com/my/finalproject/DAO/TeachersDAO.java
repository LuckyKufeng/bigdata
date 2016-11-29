package com.my.finalproject.DAO;

import java.util.ArrayList;

import org.hibernate.Query;

import com.my.finalproject.model.Teachers;

public class TeachersDAO extends DAO{

		public ArrayList<Teachers> populateTeachers() throws Exception{
			
			try{
				Query query = getSession().createQuery("from Teachers");
				ArrayList<Teachers> list = (ArrayList<Teachers>) query.list();
				return list;
			}catch(Exception e){
				throw new Exception("Teacher table exception");
			}
		}
	
}
