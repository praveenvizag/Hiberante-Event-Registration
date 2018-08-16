package com.mindtree.hibernate.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mindtree.hibernate.constant.EventRegistrationSQLConstants;
import com.mindtree.hibernate.entities.Employees;
import com.mindtree.hibernate.entities.Events;
import com.mindtree.hibernate.exception.EventAlreadyRegisteredException;
import com.mindtree.hibernate.exception.MIDDoesNotExistException;

public class EventRegistrationImplDAO implements EventRegistrationDAO {
	private Logger logger = Logger.getLogger(EventRegistrationImplDAO.class.getName());
	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

	@Override
	public void createEventEntriesIntoDatabase(Map<String, Employees> employeesMap, Map<String, Events> eventsMap)
			throws Exception {
		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			session.save(employeesMap.get("emp1"));
			session.save(employeesMap.get("emp2"));
			session.save(employeesMap.get("emp3"));
			session.save(employeesMap.get("emp4"));
			session.save(eventsMap.get("event1"));
			session.save(eventsMap.get("event2"));
			session.save(eventsMap.get("event3"));
			session.save(eventsMap.get("event4"));
			session.getTransaction().commit();

		} catch (HibernateException e) {
			e.printStackTrace();
			logger.error("Error occured while inserting data in to databse");
			throw new Exception("Error occured while inserting data in to databse");
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public void registerEventsForEmployees(int choice, String mid)
			throws EventAlreadyRegisteredException, MIDDoesNotExistException, Exception {
		List<Events> events = new ArrayList<>();
		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			Query query = session.createQuery(EventRegistrationSQLConstants.EVENTS_SQL);
			query.setParameter(EventRegistrationSQLConstants.EVENTID, choice);
			events = query.list();
			Query employeeQuery = session.createQuery(EventRegistrationSQLConstants.EMPLOYEES_SQL);
			employeeQuery.setParameter(EventRegistrationSQLConstants.MID, mid);
			List<Employees> employeeList = employeeQuery.list();
			checkForRegisteredEvents(mid, employeeList, choice);
			Events eventData = events.get(0);
			Employees employeeData = employeeList.get(0);
			employeeData.getEventList().add(eventData);
			eventData.getEmployeeList().add(employeeData);

			session.update(eventData);
			session.update(employeeData);
			session.getTransaction().commit();
			System.out.println("You are successfully registered for event " + events.get(0).getEventTitle());
		} catch (Exception exception) {

			if ((exception instanceof EventAlreadyRegisteredException
					|| exception instanceof MIDDoesNotExistException)) {
				throw new Exception("Error Occured while Registring");
			}
		}

		System.out.println("You are successfully registered for event " + events.get(0).getEventTitle());

	}

	@SuppressWarnings("unchecked")
	@Override
	public void getEventsRegisterdByMinds(int eventId) throws Exception {
		List<Employees> employees = new ArrayList<>();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.createQuery(EventRegistrationSQLConstants.EVENTS_SQL);
		query.setParameter(EventRegistrationSQLConstants.EVENTID, eventId);
		List<Events> events = query.list();
		Events event = events.get(0);
		Integer primaryKey = event.getEventId();
		if (primaryKey != 0) {
			Events e = (Events) session.get(Events.class, primaryKey);
			employees.addAll(e.getEmployeeList());

		} else {
			System.out.println("No events are Available");
		}
		if (!employees.isEmpty()) {
			Query eventquery = session.createQuery(EventRegistrationSQLConstants.EVENT_TITLE_SQL);
			eventquery.setParameter("eventid", eventId);
			List<Events> eventNames = query.list();
			Events eventName = eventNames.get(0);
			System.out
					.println("======Below Minds are Registered for the Event :" + eventName.getEventTitle() + "=======");
			for (Employees e : employees) {
				System.out.println(e.getName());
			}
		} else {
			System.out.println("You have not Registered for any Event yet");
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public void viewEmployee() throws Exception {
		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			List<Employees> list = session.createQuery(EventRegistrationSQLConstants.EMPLOYEE_NAME).list();
			for (int i = 0; i < list.size(); i++) {
				System.out.println("" + (i + 1) + ". " + list.get(i));
			}

		} catch (HibernateException e) {
			e.printStackTrace();
			logger.error("Error occured while retrieving employee from Database");
			throw new Exception("Error occured while retrieving employee from Database");
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public void getEmployeeEvents(final String mid) throws EventAlreadyRegisteredException, MIDDoesNotExistException {
		Session session = sessionFactory.openSession();
		List<Events> eventsList = new ArrayList<>();
		Query employeeQuery = session.createQuery(EventRegistrationSQLConstants.EMPLOYEES_SQL);
		employeeQuery.setParameter(EventRegistrationSQLConstants.MID, mid);
		List<Employees> employeeData = employeeQuery.list();
		isMIDExists(employeeData,mid);
		Integer primaryKey = employeeData.get(0).getSerial_number();
		if (primaryKey != 0) {
			Employees employeeEvents = (Employees) session.get(Employees.class, primaryKey);
			eventsList.addAll(employeeEvents.getEventList());
		}
		if (!eventsList.isEmpty()) {
			System.out.println("======You Are Registered for below Event===== ");
			for (Events e : eventsList) {
				System.out.println(e.getEventTitle());
			}
		} else {
			System.out.println("You have not Registered for any Event yet");
		}

	}

	private void isMIDExists(List<Employees> midList, String mid) throws MIDDoesNotExistException {
		if (midList.isEmpty()) {
			System.out.println(" MID :"+ mid.toUpperCase() + " doesnt Exists. Please enter valid MID");
			throw new MIDDoesNotExistException("MID does not exist!!!");
		}
	}

	private void checkForRegisteredEvents(String mid, List<Employees> empList, int choice)
			throws EventAlreadyRegisteredException, MIDDoesNotExistException {

		if (!empList.isEmpty()) {
			List<Events> eventList = (List<Events>) empList.get(0).getEventList();
			for (int i = 0; i < eventList.size(); i++) {
				if (choice == eventList.get(i).getEventId()) {
					System.out.println("=====You are already registered for this event "  + eventList.get(i).getEventTitle() + "!!!\n Please select a different one.=====");
					throw new EventAlreadyRegisteredException(
							"You have already registered for this event !!!\n Please select a different one.");
				}
			}
		} else {
			System.out.println(" MID doesnt Exists");
			throw new MIDDoesNotExistException("MID does not exist!!!");
		}
	}

}
