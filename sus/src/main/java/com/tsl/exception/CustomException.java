package com.tsl.exception;

public class CustomException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// Default constructor
    public CustomException() {
        super();
    }

    // Constructor that accepts a message
    public CustomException(String message) {
        super(message);
    }

    // Constructor that accepts a message and a cause
    public CustomException(String message, Throwable cause) {
        super(message, cause);
    }

    // Constructor that accepts a cause
    public CustomException(Throwable cause) {
        super(cause);
    }
}