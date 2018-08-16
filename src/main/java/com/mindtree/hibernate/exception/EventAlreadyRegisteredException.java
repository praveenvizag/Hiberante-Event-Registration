package com.mindtree.hibernate.exception;

public class EventAlreadyRegisteredException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2883021846100080208L;

	public EventAlreadyRegisteredException() {
		super();
	}

	public EventAlreadyRegisteredException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public EventAlreadyRegisteredException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public EventAlreadyRegisteredException(String arg0) {
		super(arg0);
	}

	public EventAlreadyRegisteredException(Throwable arg0) {
		super(arg0);
	}

}
