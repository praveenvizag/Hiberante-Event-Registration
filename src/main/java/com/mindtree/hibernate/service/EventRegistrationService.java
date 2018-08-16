package com.mindtree.hibernate.service;

import java.text.ParseException;

import com.mindtree.hibernate.exception.EventAlreadyRegisteredException;
import com.mindtree.hibernate.exception.MIDDoesNotExistException;

public interface EventRegistrationService {
	void createEventEntriesIntoDatabase() throws ParseException, Exception;

	void registerEventsForEmployee(int choice, String mid) throws Exception;

	void viewEmployee() throws Exception;

	void getEmployeeEvents(String mid) throws EventAlreadyRegisteredException, MIDDoesNotExistException;

	void eventsRegisterdByMinds(int eventId) throws Exception;
}
