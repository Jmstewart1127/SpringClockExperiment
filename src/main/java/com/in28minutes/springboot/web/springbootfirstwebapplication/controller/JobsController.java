package com.in28minutes.springboot.web.springbootfirstwebapplication.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.in28minutes.springboot.web.springbootfirstwebapplication.model.Jobs;
import com.in28minutes.springboot.web.springbootfirstwebapplication.service.JobsService;

@Controller
public class JobsController {
	
	@Autowired
	JobsService jobsService;
	
	@RequestMapping(path="/newjob", method = RequestMethod.GET)
	public ModelAndView showNewJobForm(ModelAndView modelAndView, Jobs jobs) {
		modelAndView.addObject("jobs", jobs);
		modelAndView.setViewName("newjob");
		
		return modelAndView;
	}
	
	@RequestMapping(value = "/newjob", method = RequestMethod.POST)
	public ModelAndView processJobRegistrationForm(ModelAndView modelAndView, 
			@Valid Jobs jobs, BindingResult bindingResult, HttpServletRequest request) {
				
		Jobs jobExists = jobsService.findById(jobs.getId());
		
		System.out.println(jobExists);
		
		if (jobExists != null) {
			modelAndView.addObject("alreadyRegisteredMessage", 
					"Oops!  There is already a user registered with the email provided.");
			modelAndView.setViewName("register");
			bindingResult.reject("email");
		}
			
		if (bindingResult.hasErrors()) { 
			modelAndView.setViewName("newuser");		
		} else { 
		    jobs.setAmountCharged(jobs.getAmountDue());    
		    jobsService.saveJobs(jobs);
		    
			modelAndView.addObject(jobs.getJobName());
			modelAndView.setViewName("newjobadded");
		}
			
		return modelAndView;
	}
	
	@RequestMapping(path="/jobpayments", method = RequestMethod.GET)
	public ModelAndView showJobUpdateForm(ModelAndView modelAndView, Jobs jobs) {
		modelAndView.addObject("jobs", jobs);
		modelAndView.setViewName("updatejobstatus");
		
		return modelAndView;
	}
	
	@RequestMapping(value = "/jobpayments", method = RequestMethod.POST)
	public ModelAndView processJobUpdateForm(ModelAndView modelAndView, 
			@Valid Jobs jobs, BindingResult bindingResult, HttpServletRequest request) {
				
		Jobs jobExists = jobsService.findById(jobs.getId());
		
		System.out.println(jobExists);
		
		if (jobExists != null) {
			modelAndView.addObject("alreadyRegisteredMessage", 
					"Oops!  There is already a user registered with the email provided.");
			modelAndView.setViewName("register");
			bindingResult.reject("email");
		}
			
		if (bindingResult.hasErrors()) { 
			modelAndView.setViewName("updatejobstatus");		
		} else { 
			String customerName = jobs.getCustomerName();
			double amountPaid = jobs.getAmountPaid();
			System.out.println(customerName + " name");
			System.out.println(amountPaid + " paid");
		    jobsService.addPayment(customerName, amountPaid);   
		    
			modelAndView.setViewName("newjobadded");
		}
			
		return modelAndView;
	}
	
    @RequestMapping(path="showjobs", method = RequestMethod.GET)
    public ModelAndView showJobs() {
        ModelAndView mav = new ModelAndView("showjobs");
        mav.addObject("jobs", jobsService.findAll());
        
        return mav;
    }
    
	@RequestMapping(value="/jobs/{id}/update", method = RequestMethod.GET)
    public ModelAndView showUpdateJobsPage(ModelAndView modelAndView, @PathVariable int id) {
		Jobs jobs = jobsService.findById(id);
		modelAndView.addObject("jobs", jobs);
		modelAndView.setViewName("updatejobs");
        return modelAndView;
	}
    
    @RequestMapping(value="/jobs/{id}/update",method=RequestMethod.POST)
	public ModelAndView processJobEditForm(ModelAndView modelAndView,
			@PathVariable int id,@Valid Jobs jobs, BindingResult bindingResult, 
			HttpServletRequest request) {
			
		if (bindingResult.hasErrors()) { 
			modelAndView.setViewName("updatejobstatus");		
		} else { 
 
			modelAndView.setViewName("showjobs");
			jobsService.saveJobs(jobs);
		}
			
		return modelAndView;
	}
   
	@RequestMapping(value="/jobs/{id}/delete", method = RequestMethod.GET)
    public ModelAndView deleteJob(ModelAndView modelAndView, @Valid Jobs jobs, @PathVariable int id) {
		modelAndView.addObject(jobs);
		modelAndView.setViewName("showjobs");
		jobsService.deleteJob(id);
        return modelAndView;
	}    

	
}
