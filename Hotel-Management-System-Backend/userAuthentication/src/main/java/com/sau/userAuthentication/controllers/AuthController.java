package com.sau.userAuthentication.controllers;

import java.util.HashSet;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sau.userAuthentication.models.ERole;
import com.sau.userAuthentication.models.Role;
import com.sau.userAuthentication.models.User;
import com.sau.userAuthentication.payload.request.LoginRequest;
import com.sau.userAuthentication.payload.request.SignupRequest;
import com.sau.userAuthentication.payload.response.JwtResponse;
import com.sau.userAuthentication.payload.response.MessageResponse;
import com.sau.userAuthentication.repository.RoleRepository;
import com.sau.userAuthentication.repository.UserRepository;
import com.sau.userAuthentication.security.JwtUtils;
import com.sau.userAuthentication.security.UserDetailsImpl;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/auth")
public class AuthController {
	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtUtils jwtUtils;

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);
		
		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();		
		List<String> roles = userDetails.getAuthorities().stream()
				.map(item -> item.getAuthority())
				.collect(Collectors.toList());

		return ResponseEntity.ok(new JwtResponse(jwt, 
												 userDetails.getId(), 
												 userDetails.getUsername(), 
												 userDetails.getEmail(), 
												 roles));
	}
     @PostMapping("/role")
     public Role getrole(@RequestBody Role role) {
    	 Role roles = roleRepository.save(role);
    	 return roles;
     }
	

	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
		if (userRepository.existsByUsername(signUpRequest.getUsername())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Username is already taken!"));
		}

		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Email is already in use!"));
		}

		// Create new user's account
		User user = new User(signUpRequest.getUsername(), 
							 signUpRequest.getEmail(),
							 
							 encoder.encode(signUpRequest.getPassword()));

		String strRole = signUpRequest.getRole();
		Set<Role> role = new HashSet<>();

		if (strRole == null) {
			Role userRole = roleRepository.findByName(ERole.ROLE_OWNER)
					.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
			role.add(userRole);
		} else {
		
				switch (strRole) {
				
				case "MANAGER":
					Role adminRole = roleRepository.findByName(ERole.ROLE_MANAGER)
							.orElseThrow(() -> new RuntimeException("Error: MANAGER Role is not found."));
					role.add(adminRole);

					break;
				case "RECEPTIONIST":
					Role adminRole1 = roleRepository.findByName(ERole.ROLE_RECEPTIONIST)
							.orElseThrow(() -> new RuntimeException("Error: RECEPTIONIST Role is not found."));
					role.add(adminRole1);

					break;
				
				case "OWNER":
					Role userRole = roleRepository.findByName(ERole.ROLE_OWNER)
							.orElseThrow(() -> new RuntimeException("Error: Owner Role is not found."));
					role.add(userRole);
				}
			
		}

		user.setRoles(role);
		userRepository.save(user);

		return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
	}
	

	// ...

	@PutMapping("/users/{userId}")
	public ResponseEntity<?> updateUser(@PathVariable String userId, @Valid @RequestBody SignupRequest updatedUserData) {
	    // Check if the user exists
	    if (!userRepository.existsById(userId)) {
	        return ResponseEntity
	                .notFound()
	                .build();
	    }

	    // Get the user to update
	    User user = userRepository.findById(userId).orElse(null);
	    if (user == null) {
	        return ResponseEntity
	                .notFound()
	                .build();
	    }

	    // Update user data
	    user.setUsername(updatedUserData.getUsername());
	    user.setEmail(updatedUserData.getEmail());
	    if (!updatedUserData.getPassword().isEmpty()) {
	        user.setPassword(encoder.encode(updatedUserData.getPassword()));
	    }
	    // You may add additional update logic here if needed

	    // Save the updated user (this will update the existing document, not create a new one)
	    userRepository.save(user);

	    return ResponseEntity.ok(new MessageResponse("User data updated successfully!"));
	}
	
	

	@DeleteMapping("/users/{userId}")
	public ResponseEntity<?> deleteUser(@PathVariable String userId) {
	    // Check if the user exists
	    if (!userRepository.existsById(userId)) {
	        return ResponseEntity
	                .notFound()
	                .build();
	    }

	    // Delete the user
	    userRepository.deleteById(userId);

	    return ResponseEntity.ok(new MessageResponse("User deleted successfully!"));
	}


	

}