package com.in28minutes.springboot.web.springbootfirstwebapplication.model;

import java.util.Date;

import org.joda.time.DateTime;

public class Clock {
	
	private int id;
	private String user;
	private Date clockIn;
	private Date clockOut;
	private long shiftTime; 
	private long weekTime;
	
	Clock() {
		super();
	}
	
	public Clock(int id, String user, Date clockIn) {
		
		super();
		this.id = id;
		this.user = user;
		this.clockIn = clockIn;
	}
	
	public Clock(int id, String user, Date clockIn, Date clockOut, long shiftTime, 
			long weekTime) {
		
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

	public Date getClockIn() {
		return clockIn;
	}

	public void setClockIn(Date clockIn) {
		this.clockIn = clockIn;
	}

	public Date getClockOut() {
		return clockOut;
	}

	public void setClockOut(Date clockOut) {
		this.clockOut = clockOut;
	}

	public long getShiftTime() {
		return shiftTime;
	}

	public void setShiftTime(long shiftTime) {
		this.shiftTime = shiftTime;
	}

	public long getWeekTime() {
		return weekTime;
	}

	public void setWeekTime(long weekTime) {
		this.weekTime = weekTime;
	}
	
	
	
}
