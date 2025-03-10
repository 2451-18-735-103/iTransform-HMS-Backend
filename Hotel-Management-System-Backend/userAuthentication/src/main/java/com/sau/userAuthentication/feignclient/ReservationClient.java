package com.sau.userAuthentication.feignclient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.sau.userAuthentication.models.Reservation;



@FeignClient(name = "reservation-service",url = "http://localhost:8082/reservation")
public interface ReservationClient {

	
	@PostMapping("/addreservation")
	public ResponseEntity<String> addReservation(@RequestBody Reservation reservation);
	
	@PutMapping("/updatereservation/{reservationId}")
	public ResponseEntity<String> updateReservation(@PathVariable String reservationId,@RequestBody Reservation reservation);
	
	@DeleteMapping("/deletereservation/{reservationId}")
	public ResponseEntity<String> deleteReservation(@PathVariable String reservationId);
	
	@GetMapping("/viewAllReservations")
	public ResponseEntity<List<Reservation>> viewAllReservation() ;
	
}
