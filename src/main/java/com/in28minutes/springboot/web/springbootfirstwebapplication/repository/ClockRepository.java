package com.in28minutes.springboot.web.springbootfirstwebapplication.repository;

import org.springframework.data.repository.CrudRepository;

import com.in28minutes.springboot.web.springbootfirstwebapplication.model.Clock;

public interface ClockRepository extends CrudRepository <Clock, Long> {

}
