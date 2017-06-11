package com.in28minutes.springboot.web.springbootfirstwebapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.in28minutes.springboot.web.springbootfirstwebapplication.model.Clock;
import com.in28minutes.springboot.web.springbootfirstwebapplication.repository.ClockRepository;
import com.in28minutes.springboot.web.springbootfirstwebapplication.service.ClockService;

@Controller
@SessionAttributes("user")
public class ClockController {
	
	@Autowired
	ClockService clockService;
	
	@Autowired
	ClockRepository clockRepository;
	
	@RequestMapping(value="/time",  method = RequestMethod.GET)
	public String showClockInPage() {
        return "clockin";
	}
	
	@GetMapping(path="/add") // Map ONLY GET Requests
	public @ResponseBody String addNewUser (@RequestParam String name) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request
		clockService.addNewUser(name);
		
		return "Saved";
	}
	
	@GetMapping(path="/start") // Map ONLY GET Requests
	public @ResponseBody String clockIn (@RequestParam int id) {
		clockService.clockIn(id);

		return "Saved";
	}
	
	@GetMapping(path="/end") // Map ONLY GET Requests
	public @ResponseBody String clockOut (@RequestParam int id) {
		clockService.clockOut(id);

		return "Saved";
	}
	
	@GetMapping(path="/all")
	public @ResponseBody Iterable<Clock> getAllUsers() {
		// This returns a JSON or XML with the users
		return clockRepository.findAll();
	}
	

}
