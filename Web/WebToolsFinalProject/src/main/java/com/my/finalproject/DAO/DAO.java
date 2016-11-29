package com.my.finalproject.DAO;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.my.finalproject.DAO.HibernateUitl;;

public abstract class DAO {
	     
		   public Session getSession(){
			   return HibernateUitl.getSessionFactory().openSession();
		   }
			 
		   protected DAO() {
		   }


		   protected Transaction begin() {
		       Transaction tx= getSession().beginTransaction();
		       return tx;
		   }

		   protected void commit() {
		       getSession().getTransaction().commit();
		   }

		   protected void rollback() {
		       try {
		           getSession().getTransaction().rollback();
		       } catch (HibernateException e) {
		          
		       }
		       try {
		           getSession().close();
		       } catch (HibernateException e) {
		          
		       }
		      
		   }

		   public  void close() {
		       getSession().close();
		   }
			
			
}
	

