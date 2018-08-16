package com.mindtree.hibernate.constant;

public interface EventRegistrationSQLConstants {
	
	String EVENTS_SQL = " from Events where eventId=:eventid";
	String EMPLOYEES_SQL = " from Employees where mId =:mid";
	String EVENT_TITLE_SQL = " Select eventTitle from Events where eventId=:eventid";
	String EMPLOYEE_NAME = "select name from Employees";
	String MID = "mid";
	String EVENTID = "eventid";

}
