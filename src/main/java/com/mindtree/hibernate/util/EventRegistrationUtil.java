package com.mindtree.hibernate.util;

import com.mindtree.hibernate.exception.InvalidInputException;

public final class EventRegistrationUtil {

	private EventRegistrationUtil() {
	}

	public static void displayMenuForEventRegistarion() {
		System.out.println("\n********** WELCOME TO EVENT REGISTRATION ********** \n");
		System.out.println("Please Enter Your Choice\n");
		System.out.println("0. Create Entries In to Database");
		System.out.println("1. Register For An EVENT");
		System.out.println("2. VIEW the list of Employees");
		System.out.println("3. Check the employees Registered for a particular event");
		System.out.println("4. Check the events that a mind has registered");
		System.out.println("5. EXIT");
		
	}
	
	public static boolean validateMID(String mId) throws InvalidInputException {
		if(mId.length()!=7 && mId.charAt(0)!='m' && mId.charAt(0)!='M')
		{
			System.out.println("Please enter the correct MID in the format 'M123456'. You entered - "+mId);
			System.out.println("MID starts with M or m. Please enter correct MID. You entered - "+mId);
			return Boolean.FALSE;
		}
			String temp=mId;
		    String split=temp.substring(1, temp.length());
		    String regex="\\d+";
		    if(!split.matches(regex)) {
		    	return Boolean.FALSE;
		    }
			    
			return Boolean.TRUE;
	}

	public static void displayMenuForEvents() {
		System.out.println("Please enter your MID and select an event to register. The events are - \n1. Trekking\n2. Guitar Classes\n3. Yoga Classes\n4. Health & Diet tips\n\nPlease enter the MID");
		
	}
	
	public static void displayEvents() {
		System.out.println(" The events are - \n1. Trekking\n2. Guitar Classes\n3. Yoga Classes\n4. Health & Diet tips\n\nPlease enter the Event Id");
		
	}
}
