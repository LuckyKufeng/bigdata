package com.my.finalproject.DAO;

import java.util.ArrayList;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.my.finalproject.model.FileTable;
import com.my.finalproject.model.SharefileModel;
import com.my.finalproject.model.Teachers;
import com.my.finalproject.modelstore.Communitydataprepareobject;

public class CommunityDataDAO extends DAO{

	public ArrayList<Communitydataprepareobject> populate(){
		
		ArrayList<Communitydataprepareobject> list = new ArrayList<Communitydataprepareobject>();
		try{
			Session session = getSession();
			Query userquery = session.createQuery("from Teachers");
			Query filequery = session.createQuery("from FileTable");
			Query sharequery = session.createQuery("from SharefileModel");
			
			ArrayList<Teachers> userlist = (ArrayList<Teachers>) userquery.list();
			ArrayList<FileTable> filelist = (ArrayList<FileTable>) filequery.list();
			ArrayList<SharefileModel> sharelist = (ArrayList<SharefileModel>) sharequery.list();
			
			for(int i=0; i < userlist.size();i++){
				Communitydataprepareobject model = new Communitydataprepareobject();
				Teachers teacher = userlist.get(i);
				model.setName(teacher.getName());
				for(int j=0; j < filelist.size();j++){
					FileTable file = filelist.get(j);
					if(teacher.getUsername().equals(file.getUsername())){
						model.getFiletables().add(file);
						for(int k=0;k < sharelist.size();k++){
							if(file.getFileName().equals(sharelist.get(k).getFilename())){
								model.getDates().add(sharelist.get(k).getDate());
							}
						}
					}
				}
				list.add(model);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return list;
	}
	
}
