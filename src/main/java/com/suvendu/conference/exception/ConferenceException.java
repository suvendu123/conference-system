package com.suvendu.conference.exception;

public class ConferenceException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3394891966528801506L;

	public ConferenceException(String message, Throwable cause) {
		super(message, cause);
	}

	public ConferenceException(String message) {
		super(message);
	}

	public ConferenceException(Throwable cause) {
		super(cause);
	}
	
	
	

}
