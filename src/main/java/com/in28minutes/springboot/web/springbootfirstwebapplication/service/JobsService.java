package com.in28minutes.springboot.web.springbootfirstwebapplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.in28minutes.pringbot.web.springbootfirstwebapplication.logistics.PaymentLogic;
import com.in28minutes.springboot.web.springbootfirstwebapplication.model.Jobs;
import com.in28minutes.springboot.web.springbootfirstwebapplication.repository.JobsRepository;

@Service
public class JobsService {

	@Autowired
	JobsRepository jobsRepository;
	
	public Jobs findById(int id) {
		return jobsRepository.findById(id);
	}
	
	public Jobs findByCategory(String category) {
		return jobsRepository.findByCategory(category);
	}
	
	public Jobs findByCustomerName(String customer) {
		return jobsRepository.findByCustomerName(customer);
	}
	
	public double findBalanceDueByCustomerName(String customerName) {
		return jobsRepository.findAmountDueByCustomerName(customerName);
	}
	
	public void updateAmountDueByCustomerName(int id, double amountPaid, double amountDue) {
		jobsRepository.updateAmountDue(id, amountPaid, amountDue);
	}
	
	public int findIdByCustomerName(String customerName) {
		return jobsRepository.findIdByCustomerName(customerName);
	}
	
	public void addPayment(String customerName, double amountPaid) {
		PaymentLogic pl = new PaymentLogic();
		double amountDue = jobsRepository.findAmountDueByCustomerName(customerName);
		int id = findIdByCustomerName(customerName);
		pl.makePayment(amountDue, amountPaid);
		double newAmountDue = pl.getBalanceDue();
		jobsRepository.updateAmountDue(id, amountPaid, newAmountDue);
	}
	
	public Jobs saveJobs(Jobs jobs) {
		return jobsRepository.save(jobs);
	}
	
}
