package com.in28minutes.springboot.web.springbootfirstwebapplication.service;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;
import org.springframework.stereotype.Service;
import com.in28minutes.springboot.web.springbootfirstwebapplication.model.Clock;

@Service
public class ClockService {
	
	private static List<Clock> clock = new ArrayList<Clock>();
	private int clockCount = 0;
	
	
    public void clockIn(String name, DateTime now) {
        clock.add(new Clock(clockCount++, name, now));
    }


	public void clockIn(Object setClockIn) {
		// TODO Auto-generated method stub
		
	}
	
	
}
