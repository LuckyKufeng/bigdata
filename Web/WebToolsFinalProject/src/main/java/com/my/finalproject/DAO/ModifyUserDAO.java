package com.my.finalproject.DAO;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.my.finalproject.model.Teachers;

public class ModifyUserDAO extends DAO{
	
	public void updataTeacher(String username,String name, String officeinfo){
		try{
			Session session = getSession();
			Transaction tx = session.beginTransaction();
			Query query = session.createQuery("from Teachers where username = :username");
			query.setString("username", username);
			
			Teachers teacher = (Teachers) query.uniqueResult();
			teacher.setName(name);
			teacher.setOfficeinfo(officeinfo);
			
			tx.commit();
			session.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
}
