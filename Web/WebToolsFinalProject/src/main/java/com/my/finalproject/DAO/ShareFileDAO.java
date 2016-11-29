package com.my.finalproject.DAO;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.my.finalproject.model.SharefileModel;

public class ShareFileDAO extends DAO{

		public void shareFile(String filename, String date) {
			
			try{
				Session session = getSession();
				Transaction tx = session.beginTransaction();
				
				SharefileModel model = new SharefileModel();
				model.setDate(date);
				model.setFilename(filename);
				
				session.save(model);
				tx.commit();
				session.close();
			}catch(Exception e){
				e.printStackTrace();
			}
			
		}
}
