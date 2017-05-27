/**
 * 
 */
package com.in28minutes.pringbot.web.springbootfirstwebapplication.clocklogic;


import java.util.ArrayList;
import java.util.Date;

/**
 * @author Jacob Stewart
 * 
 * Handles Logic
 *
 */
public class ClockLogic {

	private Date startTime = new Date();
	private Date endTime;
	private long shiftTime;
	private long weeklyTime;
	private ArrayList<Long> list  = new ArrayList<Long>(); 
	
	public ClockLogic() {}

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
	
	private long calcShiftTime(Date start, Date end) {
		long startTime = start.getTime();
		long endTime = end.getTime();
		long shiftTime = endTime - startTime;
		
		list.add(shiftTime);
		System.out.println(shiftTime + " Shift");
		return shiftTime;
	}
	
	private long calcWeeklyTime() {
		long sum = 0;
		for (int i = 0; i < list.size(); i++) {
			sum += list.get(i);
		}
		
		return sum;
	}
	
	public long endShift(Date start, Date end) {
		calcShiftTime(start, end);
		return calcWeeklyTime();
	}

	
	

}
