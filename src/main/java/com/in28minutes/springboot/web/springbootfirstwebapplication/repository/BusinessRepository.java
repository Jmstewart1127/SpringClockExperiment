package com.in28minutes.springboot.web.springbootfirstwebapplication.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.in28minutes.springboot.web.springbootfirstwebapplication.model.Business;


public interface BusinessRepository extends CrudRepository <Business, Long> {
	
	Business findById(int id);
	
	Business findByBizName(String bizName);
	
	Business findByConfirmationToken(String confirmationToken);
	
//	@Query("SELECT * FROM com.in28minutes.springboot.web.springbootfirstwebapplication.model.Business WHERE biz_name= :bizName AND password = :password")
//	Date findStartTimeById(@Param("bizName")String bizName,
//			@Param("password")String password);
						
	
}
