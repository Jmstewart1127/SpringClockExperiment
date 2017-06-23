package com.in28minutes.springboot.web.springbootfirstwebapplication.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.in28minutes.springboot.web.springbootfirstwebapplication.model.Clock;
import com.in28minutes.springboot.web.springbootfirstwebapplication.service.ClockService;
import com.in28minutes.springboot.web.springbootfirstwebapplication.service.HistoryService;

@Controller
@SessionAttributes("user")
public class ClockController {
	
	@Autowired
	ClockService clockService;
	
    @RequestMapping(path="employees", method = RequestMethod.GET)
    public ModelAndView showClock() {
        ModelAndView mav = new ModelAndView("showemployees");
        mav.addObject("clock", clockService.findByBizId(1));
        
        return mav;
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
		} else { 
		        
		    clockService.saveClock(clock);
		    
			modelAndView.addObject(clock.getUser());
			modelAndView.setViewName("useradded");
		}
			
		return modelAndView;
	}
	
	@RequestMapping(path="/clock", method = RequestMethod.GET)
	public ModelAndView showClockForm(ModelAndView modelAndView, Clock clock) {
		modelAndView.addObject("clock", clock);
		modelAndView.setViewName("timeclock");
		
		return modelAndView;
	}
	
	@RequestMapping(value = "/clock", method = RequestMethod.POST)
	public ModelAndView processClockForm(ModelAndView modelAndView, 
			@Valid Clock clock, BindingResult bindingResult, HttpServletRequest request) {
		
		modelAndView.setViewName("timeclockupdate");
		
		int userId = clock.getId();
		
		Boolean isClocked = clockService.findClockedById(userId);
		
		if (isClocked) {
			clockService.clockOut(userId);
			return modelAndView;
		} else {
			clockService.clockIn(userId);
			return modelAndView;
		}

	}
	

}
