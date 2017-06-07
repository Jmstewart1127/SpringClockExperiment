package com.in28minutes.springboot.web.springbootfirstwebapplication.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.in28minutes.springboot.web.springbootfirstwebapplication.model.Clock;

public interface ClockRepository extends CrudRepository <Clock, Long> {
	Optional<Clock> findByUser(String user);
	
	List<Clock> findById(@Param("id") int id);
	  
	@Modifying
	@Transactional
	@Query("UPDATE com.in28minutes.springboot.web.springbootfirstwebapplication.model.Clock SET clock_out=:endTime, shift_time=:shiftTime, week_time=:weeklyTime WHERE id=:id")
	void updateClock(@Param("id")int id, 
			  @Param("endTime")Date endTime, 
			  @Param("shiftTime")long shiftTime, 
			  @Param("weeklyTime")long weeklyTime);
	  
}
