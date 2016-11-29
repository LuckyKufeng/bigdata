package com.my.finalproject.DAO;

import java.util.ArrayList;
import org.hibernate.Query;
import com.my.finalproject.model.Classtable;

public class ClasstableDAO extends DAO{
	
	public ArrayList<Classtable> populateClass() throws Exception{
		
		try{
			Query query = getSession().createQuery("from Classtable");
			ArrayList<Classtable> list = (ArrayList<Classtable>)query.list();
			return list;
		}catch(Exception e){
			throw new Exception("Couldn't find class information");
		}
	}
}
