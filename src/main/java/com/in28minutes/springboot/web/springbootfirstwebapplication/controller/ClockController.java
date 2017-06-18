package com.in28minutes.springboot.web.springbootfirstwebapplication.controller;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.in28minutes.springboot.web.springbootfirstwebapplication.model.Business;
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
	public @ResponseBody String addNewUser (@RequestParam int bizId, @RequestParam String name) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request
		clockService.addNewUser(bizId, name);
		
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
	
	@RequestMapping(path="/adduser", method = RequestMethod.GET)
	public ModelAndView showNewUserForm(ModelAndView modelAndView, Clock clock) {
		modelAndView.addObject("clock", clock);
		modelAndView.setViewName("newuser");
		return modelAndView;
	}
	
	// Process form input data
	@RequestMapping(value = "/adduser", method = RequestMethod.POST)
	public ModelAndView processRegistrationForm(ModelAndView modelAndView, 
			@Valid Clock clock, BindingResult bindingResult, HttpServletRequest request) {
				
		// Lookup user in database by id
		Clock clockExists = clockService.findById(clock.getId());
		
		System.out.println(clockExists);
		
		if (clockExists != null) {
			modelAndView.addObject("alreadyRegisteredMessage", 
					"Oops!  There is already a user registered with the email provided.");
			modelAndView.setViewName("register");
			bindingResult.reject("email");
		}
			
		if (bindingResult.hasErrors()) { 
			modelAndView.setViewName("newuser");		
		} else { // new user so we create user and send confirmation e-mail
		        
		    clockService.saveClock(clock);
			
			modelAndView.addObject(clock.getUser());
			modelAndView.setViewName("useradded");
		}
			
		return modelAndView;
	}
	
	
	
	@GetMapping(path="/all")
	public @ResponseBody Iterable<Clock> getAllUsers() {
		// This returns a JSON or XML with the users
		return clockRepository.findAll();
	}
	

}
