package com.mindtree.hibernate.exception;

public class MIDDoesNotExistException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4742043958665094728L;

	public MIDDoesNotExistException() {
		super();
	}

	public MIDDoesNotExistException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public MIDDoesNotExistException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public MIDDoesNotExistException(String arg0) {
		super(arg0);
	}

	public MIDDoesNotExistException(Throwable arg0) {
		super(arg0);
	}

}
