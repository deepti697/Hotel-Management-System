package com.axis.service;

import java.util.List;

import com.axis.customerdto.CustomerDto;


public interface CustomerService {
	
	public String greet();
	public CustomerDto addCustomer(CustomerDto customerdto);
	public List<CustomerDto> getAllCustomers();
	public CustomerDto getCustomerById(int id);
	public CustomerDto updateCustomer(int id,CustomerDto customerdto);
	public String deleteCustomer(int id);

}
