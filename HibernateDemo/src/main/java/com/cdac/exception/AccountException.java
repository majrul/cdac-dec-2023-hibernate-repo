package com.cdac.exception;

public class AccountException extends RuntimeException {

	public AccountException() {
	}

	public AccountException(String message, Throwable cause) {
		super(message, cause);
	}

	public AccountException(String message) {
		super(message);
	}
	
}
