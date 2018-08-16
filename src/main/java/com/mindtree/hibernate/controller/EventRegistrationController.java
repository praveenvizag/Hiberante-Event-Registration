package com.mindtree.hibernate.controller;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.mindtree.hibernate.exception.EventAlreadyRegisteredException;
import com.mindtree.hibernate.exception.InvalidInputException;
import com.mindtree.hibernate.exception.MIDDoesNotExistException;
import com.mindtree.hibernate.service.EventRegistrationImplService;
import com.mindtree.hibernate.service.EventRegistrationService;
import com.mindtree.hibernate.util.EventRegistrationUtil;

public class EventRegistrationController {
	private static EventRegistrationService eventRegistrationService = new EventRegistrationImplService();
	private static Scanner scanner = new Scanner(System.in);
	private static Logger logger = Logger.getLogger(EventRegistrationController.class.getName());

	public static void main(String[] args) throws Exception {
		int choice = 0;
		int input;
		while (choice != 5) {
			EventRegistrationUtil.displayMenuForEventRegistarion();
			while (!scanner.hasNextInt()) {
				scanner.next();
				try {
					throw new InvalidInputException("Please enter a valid number!!!");
				} catch (InvalidInputException e) {
					System.out.println(e.getMessage());
					logger.debug(e.getMessage());
				}
			}
			input = scanner.nextInt();
			choice = input;
			while (choice > 5) {
				System.out.println("Please enter a valid choice between 1-5!!!");
				int input1 = scanner.nextInt();
				choice = input1;
			}
			switch (choice) {
			
			case 0:
				try {
					eventRegistrationService.createEventEntriesIntoDatabase();
				} catch (Exception e) {
					logger.error(e.getMessage());
				}
				break;

			case 1:
				eventRegister();
				break;

			case 2:
				viewEmployee();
				break;

			case 3:
				employeeEvents();
				break;
			case 4:
				eventsRegisterdByMinds();
				break;
			case 5:
				System.out.println("\t\tTHANK YOU !!!");
				break;

			default:
				System.out.println("Please enter a valid choice !!!");
			}
		}

	}

	private static void eventsRegisterdByMinds() throws Exception {
		System.out.println("Enter Event Id to view the Registered Minds");
		EventRegistrationUtil.displayEvents();
		 int eventId = scanner.nextInt();
		 while (eventId > 4 && eventId <= 0) {
				System.out.println("Your Choice  is Invalid : Please enter valid choice betwen 1 to 4");
				int tempChoice = scanner.nextInt();
				eventId = tempChoice;

			}
		 eventRegistrationService.eventsRegisterdByMinds(eventId);
		 
		
	}

	private static void employeeEvents() throws InvalidInputException, EventAlreadyRegisteredException, MIDDoesNotExistException {
		System.out.println("Enter MID to see events");
		String mid = scanner.next();
		boolean result = false;
		boolean flag = EventRegistrationUtil.validateMID(mid);
		if (!flag) {
			System.out.println("MID is Invalid : Please enter valid MID");
			while (flag != true) {
				String mid1 = scanner.next();
				mid = mid1;
				result = EventRegistrationUtil.validateMID(mid);
				flag = result;
			}
		}
		eventRegistrationService.getEmployeeEvents(mid);
		
	}

	private static void eventRegister() throws Exception {
		EventRegistrationUtil.displayMenuForEvents();
		System.out.println("Enter your MID here : ");
		String mid = scanner.next();
		boolean result = false;
		boolean flag = EventRegistrationUtil.validateMID(mid);
		if (!flag) {
			System.out.println("MID is Invalid : Please enter valid MID");
			while (!flag) {
				System.out.println("MID is Invalid : Please enter valid MID");
				String mid1 = scanner.next();
				mid = mid1;
				result = EventRegistrationUtil.validateMID(mid);
				flag = result;
			}
		}

		System.out.println("Now Enter your choice between 1 to 4:  ");
		int choice = scanner.nextInt();
		while (choice > 4 && choice <= 0) {
			System.out.println("Your Choice  is Invalid : Please enter valid choice betwen 1 to 4");
			int tempChoice = scanner.nextInt();
			choice = tempChoice;

		}

		eventRegistrationService.registerEventsForEmployee(choice, mid);
	}

	private static void viewEmployee() throws Exception {
		 eventRegistrationService.viewEmployee();

	}

}
