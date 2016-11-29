package com.my.finalproject.logout;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class LogoutController {

	@RequestMapping(value="/logout")
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		ModelAndView model = new ModelAndView();
        System.out.println("SpringappController - returning hello view");
        
        request.getSession().invalidate();
        model.addObject("name", "Successfully! Log out!");
        model.setViewName("success");
        
        return model;
    }
	
}
