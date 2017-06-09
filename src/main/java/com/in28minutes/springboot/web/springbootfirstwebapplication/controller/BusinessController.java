package com.in28minutes.springboot.web.springbootfirstwebapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.in28minutes.springboot.web.springbootfirstwebapplication.model.Business;
import com.in28minutes.springboot.web.springbootfirstwebapplication.repository.BusinessRepository;

@Controller
@SessionAttributes("adminName")
public class BusinessController {
	
	@Autowired
	BusinessRepository businessRepository;
	
	private int getLoggedInBizId(ModelMap model) {
		return (int) model.get("id");
	}
	
//	@GetMapping(path="/newbusiness")
//	public String newBiz () {
//		return "newbusiness";
//	}
//	
//	
//	@PostMapping(path="/newbusiness") // Map ONLY GET Requests
//	public String addNewBusiness (@RequestParam String adminName, @RequestParam String bizName, 
//			@RequestParam String password, @RequestParam String password1) {
//		
//		if (password.equals(password1)) {
//			Business b = new Business();
//			b.setAdminName(adminName);
//			b.setBizName(bizName);
//			b.setPassword(password);
//			businessRepository.save(b);
//		}
//		
//		return "welcome";
//	}
	
	
    @GetMapping("/newbusiness")
    public String greetingForm(Model model) {
        model.addAttribute("business", new Business());
        return "newbusiness";
    }

    @PostMapping("/newbusiness")
    public String greetingSubmit(@ModelAttribute Business business) {
        return "test";
    }
	
}
