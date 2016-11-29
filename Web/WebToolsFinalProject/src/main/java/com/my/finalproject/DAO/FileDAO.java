package com.my.finalproject.DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.my.finalproject.model.FileTable;

public class FileDAO extends DAO{
	
	public List<String> getFiles(String username){
		List<String> files = new ArrayList<String>();
		try{
			Query query = getSession().createQuery("select fileName from FileTable filetable where username =:username");
			query.setString("username", username);
			files = query.list();
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		return files;
	}
	
	public void storefile(String username,String filename,String des){
		try{
			Session session = getSession();
			Transaction tx = session.beginTransaction();
		
			FileTable file = new FileTable();
			file.setFileName(filename);
			file.setUsername(username);
			file.setDes(des);
			
			session.save(file);
			tx.commit();
			close();	
		}catch(Exception e){
			e.printStackTrace();
			getSession().getTransaction().rollback();
		}
		
		
	}
	
	
}
