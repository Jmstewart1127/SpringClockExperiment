package com.in28minutes.springboot.web.springbootfirstwebapplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.in28minutes.springboot.web.springbootfirstwebapplication.model.Business;
import com.in28minutes.springboot.web.springbootfirstwebapplication.repository.BusinessRepository;

@Service
public class BusinessService {
	
	@Autowired
	BusinessRepository businessRepository;

	public Business findById(int id) {
		return businessRepository.findById(id);
	}
	
	public Business findByBizName(String bizName) {
		return businessRepository.findByBizName(bizName);
	}
	
	public Business findByConfirmationToken(String confirmationToken) {
		return businessRepository.findByConfirmationToken(confirmationToken);
	}
	
	public void saveBusiness(Business business) {
		businessRepository.save(business);
	}
	
}
