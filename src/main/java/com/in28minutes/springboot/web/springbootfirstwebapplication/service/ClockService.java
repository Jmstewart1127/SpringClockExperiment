package com.in28minutes.springboot.web.springbootfirstwebapplication.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.in28minutes.pringbot.web.springbootfirstwebapplication.clocklogic.ClockLogic;
import com.in28minutes.springboot.web.springbootfirstwebapplication.model.Clock;
import com.in28minutes.springboot.web.springbootfirstwebapplication.repository.ClockRepository;

@Service
public class ClockService {
	
	@Autowired
	ClockRepository clockRepository;

	public void addNewUser (int bizId, String name) {
		Clock c = new Clock();
		c.setBizId(bizId);
		c.setUser(name);
		clockRepository.save(c);
	}
	
	public void clockIn (int id) {
		Date d = new Date();
		clockRepository.updateClock(id, d);
	}
	
	public void clockOut (int id) {
		ClockLogic cl = new ClockLogic();
		Date d = new Date();
		cl.endShift(clockRepository.findStartTimeById(id), d);
		long currentWeek = clockRepository.findWeekTimeById(id);
		long shift = cl.getShiftTime();
		cl.calcWeeklyTime(currentWeek, shift);
		clockRepository.updateClock(id, d, cl.getShiftTime(), cl.getWeeklyTime());
	}
	
	public Boolean findClockedById(int id) {
		return clockRepository.findClockedById(id);
	}
	
	public Clock findById(int id) {
		return clockRepository.findById(id);
	}
	
	public Clock findByUser(String user) {
		return clockRepository.findByUser(user);
	}
	
	public Clock findByClocked(Boolean clocked) {
		return clockRepository.findByClocked(clocked);
	}
	
	public Clock saveClock(Clock clock) {
		return clockRepository.save(clock);
	}
	
	
}
