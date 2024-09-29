package com.hms.payment.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.hms.payment.entity.Reservation;


@FeignClient(name="reservation-service" ,url="http://localhost:8082")
public interface ReservationClient {
	
	@GetMapping("/viewreservation/{reservationId}")
	public Reservation viewReservation(@PathVariable String reservationId);
	
	

}
