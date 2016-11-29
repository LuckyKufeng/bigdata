package com.my.finalproject.fileController;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class FileDownloadController {
	@RequestMapping(value="/download",method=RequestMethod.POST)
	public String download(HttpServletRequest request,HttpServletResponse response,@RequestParam("filename")String filename){
		
		String fileaddress = "C://Users/yufeng//Documents//stsworkspace//WebToolsFinalProject//files//"+filename;
        File downloadFile = new File(fileaddress);
        FileInputStream inStream = null; 
        OutputStream outStream = null;
       
        	try {
            	inStream = new FileInputStream(downloadFile);
    		} catch (FileNotFoundException e) {
    			System.out.println(e.getMessage());
    			e.printStackTrace();
    		}
        
        
        ServletContext context = request.getSession().getServletContext();
        
        String mimeType = context.getMimeType(fileaddress);
        if (mimeType == null) {        
            // set to binary type if MIME mapping not found
            mimeType = "application/octet-stream";
        }
        System.out.println("MIME type: " + mimeType);
        
        response.setContentType(mimeType);
        response.setContentLength((int) downloadFile.length());
        
        String headerKey = "Content-Disposition";
        String headerValue = String.format("attachment; filename=\"%s\"", downloadFile.getName());
        response.setHeader(headerKey, headerValue);
      
        // obtains response's output stream
        try {
        	outStream = response.getOutputStream();
			byte[] buffer = new byte[4096];
	        int bytesRead = -1;
	         
	        while ((bytesRead = inStream.read(buffer)) != -1) {
	            outStream.write(buffer, 0, bytesRead);
	        }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        finally{
        	if(inStream != null){
            	try {
    				inStream.close();
    			} catch (IOException thise) {
    				// TODO Auto-generated catch block
    				thise.printStackTrace();
    			}
            }
        	if( outStream != null){
        		try{
        			outStream.close();
        		}catch(IOException thate){
        			thate.printStackTrace();
        		}
        	}
        }
        
        return "community";
	}
}
