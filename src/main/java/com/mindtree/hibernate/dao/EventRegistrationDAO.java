package com.mindtree.hibernate.dao;

import java.util.Map;

import com.mindtree.hibernate.entities.Employees;
import com.mindtree.hibernate.entities.Events;
import com.mindtree.hibernate.exception.EventAlreadyRegisteredException;
import com.mindtree.hibernate.exception.MIDDoesNotExistException;

public interface EventRegistrationDAO {

	void createEventEntriesIntoDatabase(Map<String, Employees> employeesMap, Map<String, Events> eventsMap) throws Exception;

	void registerEventsForEmployees(int choice, String mid) throws Exception;

	void viewEmployee() throws Exception;

	void getEmployeeEvents(final String mid) throws EventAlreadyRegisteredException, MIDDoesNotExistException;

	void getEventsRegisterdByMinds(int eventId) throws Exception;


}
