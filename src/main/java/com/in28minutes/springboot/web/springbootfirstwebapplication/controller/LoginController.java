package com.in28minutes.springboot.web.springbootfirstwebapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.in28minutes.springboot.web.springbootfirstwebapplication.service.LoginService;

/**
 * Created by Jacob Stewart on 5/22/2017.
 */

@Controller
@SessionAttributes("name")
public class LoginController {
	
	@Autowired
	LoginService service;
    
	@RequestMapping(value="/", method = RequestMethod.GET)
    public String showLoginPage(ModelMap model) {
    	//model.put("name", name);
		model.put("name", "jake");
        return "welcome";
    
	}
	
}
