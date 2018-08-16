package com.mindtree.hibernate.exception;

public class NotYetRegisteredException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7228546351286387423L;

	public NotYetRegisteredException() {
		super();
	}

	public NotYetRegisteredException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public NotYetRegisteredException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public NotYetRegisteredException(String arg0) {
		super(arg0);
	}

	public NotYetRegisteredException(Throwable arg0) {
		super(arg0);
	}
	

}
