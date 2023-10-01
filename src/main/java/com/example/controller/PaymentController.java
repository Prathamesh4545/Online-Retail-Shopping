package com.example.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Payment;
import com.example.services.PaymentService;

@RestController
@RequestMapping(name="payment")
public class PaymentController {

	@Autowired
	PaymentService paymentService;
	
	@PostMapping("payment/checkout/{orderId}")
	public Payment checkout(@RequestBody Payment payment,@PathVariable int orderId) {
		return paymentService.checkout(payment, orderId);
	}
	
	
	@GetMapping("payment/history")
	public List<Payment> history(){
		return paymentService.history();
	}
}
