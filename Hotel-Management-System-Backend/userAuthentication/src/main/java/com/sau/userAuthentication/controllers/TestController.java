package com.sau.userAuthentication.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestController {
	
	
	
	@GetMapping("/all")
	public String allAccess() {
		return "Public Content.";
	}
	
	@GetMapping("/user")
	@PreAuthorize("hasRole('ROLE_RECEPTIONIST') or hasRole('ROLE_OWNER') or hasRole('ROLE_MANAGER')")
	public String userAccess() {
		return "receptionist Content.";
	}

	@GetMapping("/mod")
	@PreAuthorize("hasRole('ROLE_MANAGER')")
	public String moderatorAccess() {
		return "MANAGER Board.";
	}

	@GetMapping("/admin")
	@PreAuthorize("hasRole('ROLE_OWNER')")
	public String adminAccess() {
		return "OWner Board.";
	}
}
