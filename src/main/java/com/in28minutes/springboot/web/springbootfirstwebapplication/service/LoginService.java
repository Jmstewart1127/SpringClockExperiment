package com.in28minutes.springboot.web.springbootfirstwebapplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.in28minutes.springboot.web.springbootfirstwebapplication.repository.BusinessRepository;

@Component
public class LoginService {
	
	@Autowired
	BusinessRepository businessRepository;
	
	public boolean validateUser(String userid, String password) {
		return userid.equalsIgnoreCase("jake")
				&& password.equalsIgnoreCase("password");
	}
	
}
