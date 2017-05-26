/**
 * 
 */
package com.in28minutes.pringbot.web.springbootfirstwebapplication.clock;


import java.util.Date;

/**
 * @author Jacob Stewart
 * 
 * Handles Logic
 *
 */
public class Clock {

	private Date startTime = new Date();
	private Date endTime = new Date();
	private long shiftTime;
	private long weeklyTime;
	
	public Clock() {
		
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public long getShiftTime() {
		return shiftTime;
	}

	public void setShiftTime(long shirfTime) {
		this.shiftTime = shirfTime;
	}

	public long getWeeklyTime() {
		return weeklyTime;
	}

	public void setWeeklyTime(long weeklyTime) {
		this.weeklyTime = weeklyTime;
	}
	
	private long calcShift(Date start, Date end) {
		long startTime = start.getTime();
		long endTime = end.getTime();
		long shiftTime = endTime - startTime;
		
		setShiftTime(shiftTime);
		
		return shiftTime;
	}
	
	private long calcWeeklyTime(long shiftTime) {
		shiftTime = getShiftTime();
		shiftTime += weeklyTime;
		
		return weeklyTime;
	}
	
	public long endShift(Date start, Date end) {
		long week = calcWeeklyTime(calcShift(start, end));
		setWeeklyTime(week);
		
		return getWeeklyTime();
	}

	
	

}
