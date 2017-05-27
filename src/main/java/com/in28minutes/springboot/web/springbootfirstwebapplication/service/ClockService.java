package com.in28minutes.springboot.web.springbootfirstwebapplication.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.joda.time.DateTime;
import org.springframework.stereotype.Service;
import com.in28minutes.springboot.web.springbootfirstwebapplication.model.Clock;
import com.in28minutes.springboot.web.springbootfirstwebapplication.model.Todo;

@Service
public class ClockService {
	
	private static List<Clock> clock = new ArrayList<Clock>();
	private int clockCount = 3;
    
	static {
        clock.add(new Clock(1, "jake", new Date(), new Date(),
                100002, 33333333));
        clock.add(new Clock(2, "jakeb", new Date(), new Date(),
                103802, 33355333));
        clock.add(new Clock(3, "masterbrue", new Date(), new Date(),
                100362, 133355333));
    }
	
    public void clockIn(String name, Date start) {
        clock.add(new Clock(clockCount++, name, start));
    }
    
    public void clockOut(String name, Date end, )


	public void clockIn(Object setClockIn) {
		// TODO Auto-generated method stub
		
	}
	
	
}
