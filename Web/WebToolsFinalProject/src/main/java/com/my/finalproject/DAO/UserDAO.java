package com.my.finalproject.DAO;

import org.hibernate.Query;

import com.my.finalproject.model.User;

public class UserDAO extends DAO{

		public User authUser(String username, String password) throws Exception{
			
			try{
				Query query = getSession().createQuery("from User where username =:username and password=:password");
				query.setString("username", username);
				query.setString("password", password);
				User user = (User) query.uniqueResult();
				return user;
			}catch(Exception e){
				
				throw new Exception("couldn't find user"+ username, e);
			}
		}
	
}
