package com.mindtree.hibernate.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.mindtree.hibernate.constant.EventRegistrationEnums;
import com.mindtree.hibernate.dao.EventRegistrationDAO;
import com.mindtree.hibernate.dao.EventRegistrationImplDAO;
import com.mindtree.hibernate.entities.Employees;
import com.mindtree.hibernate.entities.Events;
import com.mindtree.hibernate.exception.EventAlreadyRegisteredException;
import com.mindtree.hibernate.exception.MIDDoesNotExistException;

public class EventRegistrationImplService implements EventRegistrationService {

	private EventRegistrationDAO eventRegistrationDAO = new EventRegistrationImplDAO();

	@Override
	public void createEventEntriesIntoDatabase() throws ParseException ,Exception{
		
		Map<String,Employees> employeesMap = employeesData();
		Map<String,Events> eventsMap = eventsData();
		
		eventRegistrationDAO.createEventEntriesIntoDatabase(employeesMap,eventsMap);

	}
	
	@Override
	public void registerEventsForEmployee(int choice, String mid) throws Exception {
		eventRegistrationDAO.registerEventsForEmployees(choice,mid);
	}
	
	@Override
	public void viewEmployee() throws Exception {
		 eventRegistrationDAO.viewEmployee();
	}
	
	@Override
	public void getEmployeeEvents(String mid) throws EventAlreadyRegisteredException, MIDDoesNotExistException {
		eventRegistrationDAO.getEmployeeEvents(mid);
	}

	@Override
	public void eventsRegisterdByMinds(int eventId) throws Exception {
		eventRegistrationDAO.getEventsRegisterdByMinds(eventId);
		
	}
	/**
	 * Class sets the events Data.
	 * @return Map of Events
	 */
	private Map<String, Events> eventsData() throws ParseException{
		Events event1= new Events("Trekking","Held every month. More details from Manish Kumar");
		Events event2= new Events("Guitar Classes","Weekly 3 sessions. Classes conducted by Daniel M");
		Events event3= new Events("Yoga Classes","Saturdays and Sundays. Classes conducted by Yamini");
		Events event4= new Events("Health & Diet tips","Every Friday 5PM to 6PM by Dr. Kishore Dutta");
		Map<String, Events> eventsMap = new HashMap<String, Events>();
		eventsMap.put("event1", event1);
		eventsMap.put("event2", event2);
		eventsMap.put("event3", event3);
		eventsMap.put("event4", event4);
		return eventsMap;
	}

	/**
	 * Class sets the Employee Data.
	 * @return Map of Employees
	 */
	private Map<String, Employees> employeesData() throws ParseException {
		Map<String, Employees> employeesMap = new HashMap<String, Employees>();
		Employees emp1 = new Employees(EventRegistrationEnums.M100100.getMid(),"Kathik Kumar",convertDate("2013-02-05"),"karthik_kumar");
		Employees emp2 = new Employees(EventRegistrationEnums.M100108.getMid(),"Ramesh Kulkarni",convertDate("2013-02-05"),"ramesh_kulkarni");
     	Employees emp3 = new Employees(EventRegistrationEnums.M100189.getMid(),"Rohit Agarwal M",convertDate("2013-03-22"),"rohit_agarwal_m");
		Employees emp4 = new Employees(EventRegistrationEnums.M101190.getMid(),"Magesh Narayanan",convertDate("2013-03-22"),"magesh_narayanan");
		employeesMap.put("emp1", emp1);
		employeesMap.put("emp2", emp2);
		employeesMap.put("emp3", emp3);
		employeesMap.put("emp4", emp4);
		return employeesMap; 
	}

	private Date convertDate(String joinDate) throws ParseException {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		return simpleDateFormat.parse(joinDate);
	}

	

	

	

	

}
