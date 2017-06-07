package com.in28minutes.springboot.web.springbootfirstwebapplication.controller;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.in28minutes.pringbot.web.springbootfirstwebapplication.clocklogic.ClockLogic;
import com.in28minutes.springboot.web.springbootfirstwebapplication.model.Clock;
import com.in28minutes.springboot.web.springbootfirstwebapplication.model.End;
import com.in28minutes.springboot.web.springbootfirstwebapplication.repository.ClockRepository;
import com.in28minutes.springboot.web.springbootfirstwebapplication.repository.EndRepository;
import com.in28minutes.springboot.web.springbootfirstwebapplication.service.ClockService;

@Controller
@SessionAttributes("user")
public class ClockController {
	
	@Autowired
	ClockService clockService;
	
	@Autowired
	ClockRepository clockRepository;
	
	@Autowired
	EndRepository endRepository;
	
//	private int getLoggedInUserId(ModelMap model) {
//		return (int) model.get("id");
//	}
	
	@RequestMapping(value="/time",  method = RequestMethod.GET)
	public String showClockInPage() {
        return "clockin";
	}
	
//	@RequestMapping(value="/time", method = RequestMethod.POST)
//	public String userClockIn(ModelMap model) {
//		if (result.hasErrors()) {
//			return "clockin";
//		}
//		
//		service.clockIn(getLoggedInUserName(model), new Date());
//        return "redirect:/showtime";
//	}
	
	@GetMapping(path="/add") // Map ONLY GET Requests
	public @ResponseBody String addNewUser (@RequestParam String name) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request
		Clock c = new Clock();
		Date d = new Date();
		c.setUser(name);
		c.setClockIn(d);
		clockRepository.save(c);
		return "Saved";
	}
	
	@GetMapping(path="/end") // Map ONLY GET Requests
	public @ResponseBody String clockOut (@RequestParam int id) {
		Clock c = new Clock();
		Date d = new Date();
		ClockLogic cl = new ClockLogic();
		Date e = new Date();
		cl.endShift(d, e);
		clockRepository.updateClock(id, e, cl.getShiftTime(), cl.getWeeklyTime());
		clockRepository.save(c);
		
		return "Saved";
	}
	
//	@GetMapping(path="/out") // Map ONLY GET Requests
//	public @ResponseBody String clockOut (@RequestParam String user) {
//		End e = new End();
//		Date d = new Date();
//		ClockLogic cl = new ClockLogic();
//
//		e.setClockOut(d);
//		e.setShiftTime(cl.getShiftTime());
//		e.setWeekTime(cl.getWeeklyTime());
//		
//		return "Saved";
//	}
	
	@GetMapping(path="/all")
	public @ResponseBody Iterable<Clock> getAllUsers() {
		// This returns a JSON or XML with the users
		return clockRepository.findAll();
	}
	
	@GetMapping(path="/alltime")
	public @ResponseBody Iterable<End> getAll() {
		// This returns a JSON or XML with the users
		return endRepository.findAll();
	}
}
