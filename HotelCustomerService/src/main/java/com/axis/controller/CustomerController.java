package com.axis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.axis.model.Customer;
import com.axis.service.CustomerService;

@RestController
@RequestMapping("/ms1")
public class CustomerController {
	

	@Autowired
	CustomerService customerService;
	
	@GetMapping("/greet")
	public String greet() {
		return customerService.greet();
	}
	
	@PostMapping("/addCustomer")
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer){
		Customer customer2 = customerService.addCustomer(customer);
		return new ResponseEntity<Customer>(customer, HttpStatus.OK);
	}
	
	@GetMapping("/getAllCustomers")
	public ResponseEntity<List<Customer>> getAllCustomers(){
		List<Customer> customers = customerService.getAllCustomers();
		return new ResponseEntity<List<Customer>>(customers, HttpStatus.OK);
	}
	
	@GetMapping("/getCustomer/{id}")
	public ResponseEntity<Customer> getCustomersById(@PathVariable int id){
		Customer customers = customerService.getCustomerById(id);
		return new ResponseEntity<Customer>(customers, HttpStatus.OK);
	}
	@PutMapping("/updateCustomer/{id}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable int id,@RequestBody Customer customer){
		return new ResponseEntity<Customer>(customerService.updateCustomer(id, customer),HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteCustomer/{id}")
	public ResponseEntity<String> deleteCustomer(@PathVariable int id){
		return new ResponseEntity<String>(customerService.deleteCustomer(id),HttpStatus.OK);
	}


}
