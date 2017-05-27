package com.in28minutes.pringbot.web.springbootfirstwebapplication.clocklogic;

import java.util.Date;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Scanner scannerIn = new Scanner(System.in);
		ClockLogic clock = new ClockLogic();
		String y = null;
		String y2 = null;
		Date s;
		Date e;
		
		
		Date start = clock.getStartTime();
		
		y = scannerIn.next();
		
		while (y.equals("y")) {
			System.out.println(s = new Date());
			y2 = scannerIn.next();
			if (y2.equals("y")) {
				System.out.println(e = new Date());
				System.out.println(clock.endShift(s, e));
			}
		}
		
		
		
		
		
	}

}
