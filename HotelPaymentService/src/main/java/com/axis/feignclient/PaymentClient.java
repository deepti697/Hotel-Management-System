package com.axis.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.axis.model.Customer;
import com.axis.model.Room;

@FeignClient(name="HOTEL-CUSTOMER-SERVICE")


public interface PaymentClient {
	
	@GetMapping("/ms1/customer/{id}")
	public Customer getCustomer(@PathVariable int id);
	
	@GetMapping("/ms3/room/{roomPrice}")
	public Room getRoomPrice(@PathVariable double roomPrice);

}
