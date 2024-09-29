package com.hms.payment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.hms.payment.entity.PaymentServiceImpl;
import com.hms.payment.entity.TransactionDetails;



@RestController
@CrossOrigin(origins = "http://localhost:4200") 
public class PaymentController {

	@Autowired
	PaymentServiceImpl impl;

	@GetMapping("/getAmount/{amount}")

	public ResponseEntity<TransactionDetails> createTransaction(@PathVariable("amount") Integer amount) {

		TransactionDetails createTransaction = impl.createTransaction(amount);

		return new ResponseEntity<>(createTransaction, HttpStatus.OK);

	}
}
