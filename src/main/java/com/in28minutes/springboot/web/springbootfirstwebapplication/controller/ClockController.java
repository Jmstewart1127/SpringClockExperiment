package com.in28minutes.springboot.web.springbootfirstwebapplication.controller;

import java.util.Date;

import javax.validation.Valid;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.in28minutes.springboot.web.springbootfirstwebapplication.model.Clock;
import com.in28minutes.springboot.web.springbootfirstwebapplication.model.Todo;
import com.in28minutes.springboot.web.springbootfirstwebapplication.service.ClockService;

@Controller
@SessionAttributes("user")
public class ClockController {
	
	@Autowired
	ClockService service;
	
	private String getLoggedInUserName(ModelMap model) {
		return (String) model.get("name");
	}
	
	@RequestMapping(value="/time",  method = RequestMethod.GET)
	public String showClockInPage() {
        return "clockin";
	}
	
	@RequestMapping(value="/time", method = RequestMethod.POST)
	public String userClockIn(ModelMap model, BindingResult result) {
		if (result.hasErrors()) {
			return "clockin";
		}
		
		service.clockIn(getLoggedInUserName(model), DateTime.now());
        return "redirect:/showtime";
		
	}
}
