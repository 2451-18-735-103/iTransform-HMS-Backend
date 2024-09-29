package com.sau.userAuthentication.feignclient;

import java.util.List;

import javax.validation.Valid;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.sau.userAuthentication.models.Guest;




@FeignClient(name = "GuestService",url = "http://localhost:9001/guest")
public interface GuestClient {

	@PostMapping("/add")
	public ResponseEntity<Guest> addGuestDetails(@Valid @RequestBody Guest guest);
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Guest> updateGuest(@PathVariable String id, @RequestBody Guest guest);
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteGuest(@PathVariable String id);
	
	@GetMapping("/{guestId}")
    public ResponseEntity<Guest> viewGuestById(@PathVariable String guestId);
	
	@GetMapping("/viewall")
	public ResponseEntity<List<Guest>> viewAllGuest();
	
}
