package com.in28minutes.pringbot.web.springbootfirstwebapplication.clocklogic;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// HashMap create
		HashMap<String, Date> map = new HashMap();
		
		// Put
		map.put("Jake", new Date());
		
		// Get set of entries
		Set set = map.entrySet();
		
		// Iterate
		Iterator i = new Iterator();
		
		// Display Elements
		while (i.hasNext()) {
			Map.Entry me = (Map.Entry)i.next();
			System.out.print(me.getKey() + ": ");
			System.out.println(me.getValue());
		}
	
		
		
		
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
