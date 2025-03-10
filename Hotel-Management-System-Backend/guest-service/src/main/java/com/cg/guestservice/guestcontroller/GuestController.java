package com.cg.guestservice.guestcontroller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.guestservice.guestentity.ExceptionResponse;
import com.cg.guestservice.guestentity.Guest;
import com.cg.guestservice.guestexception.GuestNotFoundException;
import com.cg.guestservice.guestrepository.GuestRepository;
import com.cg.guestservice.service.GuestService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/guest")
@CrossOrigin("*")
public class GuestController {
    
	@Autowired
	GuestService guestService;
	@Autowired
	GuestRepository repo;
	
	@PostMapping("/add")
	public ResponseEntity<Guest> addGuestDetails(@Valid @RequestBody Guest guest) {
//		repo.save(guest);
//		return guestService.addGuest(guest);
//		return "added guest"+ guest.getGuestId();
		//return ResponseEntity.ok(guestService.addGuest(guest));
		
			
				return ResponseEntity.ok(guestService.addGuest(guest));
				//return new ResponseEntity<>("Added",HttpStatus.OK);	
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Guest> updateGuest(@PathVariable String id, @RequestBody Guest guest){
		return ResponseEntity.ok(guestService.updateGuest(id, guest));
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteGuest(@PathVariable String id) {
		return ResponseEntity.ok(guestService.deleteGuest(id));
		//guestService.deleteGuest(id);
	}

//	@GetMapping("/view/{guestId}")
//	public Guest viewGuest(@PathVariable String guestId){
//		return guestService.viewByGuestId(guestId);
//	}
	@GetMapping("/{guestId}")
    public ResponseEntity<Guest> viewGuestById(@PathVariable String guestId) {
        Guest guest = guestService.viewGuestById(guestId);
        return new ResponseEntity<>(guest, HttpStatus.OK);
    }


	@GetMapping("/viewall")
	public ResponseEntity<List<Guest>> viewAllGuest() {
		return ResponseEntity.ok(guestService.viewAllGuest());
	}
	
}
