package com.my.finalproject.fileController;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.my.finalproject.DAO.FileDAO;
import com.my.finalproject.model.User;


@Controller
public class FileUploadController {
	
	@Autowired
	FileDAO filedao;
	
	@RequestMapping(value="/uploadfile",method=RequestMethod.POST)
	public String upload(@RequestParam("fileupload")MultipartFile file,@RequestParam("filedes") String filedes,Model model,HttpServletRequest request)throws Exception{
		
		if (!file.isEmpty()) {  // if the file we choose is not empty.
            BufferedOutputStream stream = null;
            try {
            	String filename = file.getOriginalFilename();
            	model.addAttribute("filename", filename);
            	
            	User user = (User)request.getSession().getAttribute("user");
            	String username = user.getUsername();
            	filedao.storefile(username, filename,filedes);//store file
            	
                byte[] bytes = file.getBytes(); // we translate the file with getBytes() method and store this file into a byte array.
                stream = new BufferedOutputStream(new FileOutputStream(new File("C:/Users/yufeng/Documents/stsworkspace/WebToolsFinalProject/files/" + filename)));
                // create an output stream and give the path we want to store that file.
                stream.write(bytes);//writes b.length bytes from the specified byte array to this output stream.
               
                return "mainpage";
                
            } catch (Exception e) {
               throw new Exception("error");
            }finally{// Create finally block to close the stream.
                    try{
                        if(stream != null) {// this line of code is used to avoid null pointer exception.
                            stream.close();// close this output stream
                        }
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
            }
        } else {
        	model.addAttribute("filename","Empty file");
        	return "mainpage";
        }
	
	}
	
}
