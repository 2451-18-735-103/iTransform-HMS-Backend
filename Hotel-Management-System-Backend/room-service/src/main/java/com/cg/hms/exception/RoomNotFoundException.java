package com.cg.hms.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)

public class RoomNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public RoomNotFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RoomNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
}
