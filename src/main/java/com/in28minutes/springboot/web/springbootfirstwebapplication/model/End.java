package com.in28minutes.springboot.web.springbootfirstwebapplication.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class End {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private Date clockOut;
	private long shiftTime; 
	private long weekTime;
	
	public End() {}
	
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
