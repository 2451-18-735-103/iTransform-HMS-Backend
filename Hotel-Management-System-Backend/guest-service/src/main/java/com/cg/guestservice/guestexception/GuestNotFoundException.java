package com.cg.guestservice.guestexception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class GuestNotFoundException  extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public  GuestNotFoundException(){
		super();
		// TODO Auto-generated constructor stub
	}

	public GuestNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
}
