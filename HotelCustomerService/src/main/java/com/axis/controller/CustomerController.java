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

import com.axis.customerdto.CustomerDto;
import com.axis.service.CustomerService;



@RestController
@RequestMapping("/hotel/customer")
public class CustomerController {
	

	@Autowired
	CustomerService customerService;
	
	@GetMapping("/greet")
	public String greet() {
		return customerService.greet();
	}
	
	@PostMapping("/addCustomer")
	public ResponseEntity<CustomerDto> addCustomer(@RequestBody CustomerDto customerdto){
		CustomerDto customerdto2 = customerService.addCustomer(customerdto);
		return new ResponseEntity<CustomerDto>(customerdto2, HttpStatus.OK);
	}
	
	@GetMapping("/getAllCustomers")
	public ResponseEntity<List<CustomerDto>> getAllCustomers(){
		List<CustomerDto> customerdtos = customerService.getAllCustomers();
		return new ResponseEntity<List<CustomerDto>>(customerdtos, HttpStatus.OK);
	}
	
	@GetMapping("/getCustomer/{id}")
	public ResponseEntity<CustomerDto> getCustomersById(@PathVariable int id){
		CustomerDto customerdtos = customerService.getCustomerById(id);
		return new ResponseEntity<CustomerDto>(customerdtos, HttpStatus.OK);
	}
	@PutMapping("/updateCustomer/{id}")
	public ResponseEntity<CustomerDto> updateCustomer(@PathVariable int id,@RequestBody CustomerDto customerdto){
		return new ResponseEntity<CustomerDto>(customerService.updateCustomer(id, customerdto),HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteCustomer/{id}")
	public ResponseEntity<String> deleteCustomer(@PathVariable int id){
		return new ResponseEntity<String>(customerService.deleteCustomer(id),HttpStatus.OK);
	}


}
