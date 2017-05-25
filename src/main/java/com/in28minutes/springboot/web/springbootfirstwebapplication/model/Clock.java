package com.in28minutes.springboot.web.springbootfirstwebapplication.model;

import java.util.Date;

import org.joda.time.DateTime;

public class Clock {
	
	private int id;
	private String user;
	private DateTime clockIn;
	private DateTime clockOut;
	private DateTime shiftTime; 
	private DateTime weekTime;
	
	Clock() {
		super();
	}
	
	public Clock(int id, String user, DateTime clockIn) {
		
		super();
		this.id = id;
		this.user = user;
		this.clockIn = clockIn;
	}
	
	public Clock(int id, String user, DateTime clockIn, DateTime clockOut, DateTime shiftTime, 
			DateTime weekTime) {
		
		super();
		this.id = id;
		this.user = user;
		this.clockIn = clockIn;
		this.clockOut = clockOut;
		this.shiftTime = shiftTime;
		this.weekTime = weekTime;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public DateTime getClockIn() {
		return clockIn;
	}

	public void setClockIn(DateTime clockIn) {
		this.clockIn = clockIn;
	}

	public DateTime getClockOut() {
		return clockOut;
	}

	public void setClockOut(DateTime clockOut) {
		this.clockOut = clockOut;
	}

	public DateTime getShiftTime() {
		return shiftTime;
	}

	public void setShiftTime(DateTime shiftTime) {
		this.shiftTime = shiftTime;
	}

	public DateTime getWeekTime() {
		return weekTime;
	}

	public void setWeekTime(DateTime weekTime) {
		this.weekTime = weekTime;
	}
	
	
	
}
