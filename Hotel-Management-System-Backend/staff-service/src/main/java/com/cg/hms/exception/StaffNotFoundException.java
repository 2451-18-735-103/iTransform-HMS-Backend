package com.cg.hms.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class StaffNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public StaffNotFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StaffNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
}
