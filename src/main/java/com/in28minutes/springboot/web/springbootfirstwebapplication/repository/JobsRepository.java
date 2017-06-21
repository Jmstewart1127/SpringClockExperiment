package com.in28minutes.springboot.web.springbootfirstwebapplication.repository;


import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.in28minutes.springboot.web.springbootfirstwebapplication.model.Jobs;

public interface JobsRepository extends CrudRepository <Jobs, Long> {
	
	Jobs findById(int id);
	
	Jobs findByCategory(String category);
	
	Jobs findByCustomerName(String customerName);
	
	@Query("SELECT amountDue FROM com.in28minutes.springboot.web.springbootfirstwebapplication.model.Jobs"
			+ " WHERE customer_name= :customerName")
	double findAmountDueByCustomerName(@Param("customerName")String customerName );
	
	@Query("SELECT id FROM com.in28minutes.springboot.web.springbootfirstwebapplication.model.Jobs"
			+ " WHERE customer_name= :customerName")
	int findIdByCustomerName(@Param("customerName")String customerName );
	
	@Modifying
	@Transactional
	@Query("UPDATE com.in28minutes.springboot.web.springbootfirstwebapplication.model.Jobs "
			+ "SET amount_due=:amountDue, amount_paid=:amountPaid WHERE id=:id")
	void updateAmountDue(@Param("id")int id,
			  @Param("amountPaid")double amountPaid,
			  @Param("amountDue")double amountDue); 
}
