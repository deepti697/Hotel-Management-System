package com.axis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.axis.feignclient.PaymentClient;
import com.axis.model.Customer;
import com.axis.model.Payment;
import com.axis.service.PaymentService;


@RestController
@RequestMapping("api/microservice5")
public class PaymentController {
	
	@Autowired
	PaymentClient paymentClient;
	
	@Autowired
	PaymentService paymentService;
	
	@GetMapping("/greet")
	public String greet() {
		return "Hello from Payment Service";
	}
	
	@GetMapping("/customer/{id}")
	public Customer getCustomerById(@PathVariable int id) {
		return paymentClient.getCustomer(id);
		
	}
	
	@PostMapping("/payment/{id}")
	public Payment getPayment(@PathVariable int id, @PathVariable double roomPrice) {
		return paymentService.getPayment(id, roomPrice);
		
	}
	

}
