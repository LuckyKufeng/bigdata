package com.my.finalproject.Community;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.my.finalproject.DAO.CommunityDataDAO;
import com.my.finalproject.modelstore.Communitydataprepareobject;


@Controller
public class CommunityPopulateFileController {
		
		@Autowired
		CommunityDataDAO communitydatadao;
		
		@RequestMapping(value="/filediv",method = RequestMethod.POST)
		@ResponseBody
		public ArrayList<Communitydataprepareobject> populateSharefiles(){
			
			ArrayList<Communitydataprepareobject> list = communitydatadao.populate();
			return list;
		}
}
