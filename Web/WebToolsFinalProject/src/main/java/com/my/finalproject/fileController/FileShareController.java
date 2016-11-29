package com.my.finalproject.fileController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.my.finalproject.DAO.ShareFileDAO;
import com.my.finalproject.model.SharefileModel;




@Controller
public class FileShareController {
	
	@Autowired
	ShareFileDAO sharefiledao;
	
	
	@RequestMapping(value="/fileshare",method=RequestMethod.POST)
	@ResponseBody
	public String fileshare(@RequestBody ArrayList<String> files){
		
		long yourmilliseconds = System.currentTimeMillis();
		SimpleDateFormat sdf = new SimpleDateFormat("MMM dd,yyyy HH:mm");    
		Date resultdate = new Date(yourmilliseconds);
		String date = sdf.format(resultdate);
		
		for(int i=0; i < files.size();i++){
			sharefiledao.shareFile(files.get(i), date);
		}
		
		return "mainpage";
	}
}
