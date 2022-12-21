package com.axis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axis.exception.IDNotFoundException;
import com.axis.model.Customer;
import com.axis.repository.CustomerRepository;
import com.axis.utils.AppConstants;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	
	@Autowired
	CustomerRepository customerRepository;
	
	/*
	 * @Description: This method is used  perform CRUN on customers
	 * @Param: It takes customer parameter
	 * @Returns:It returns customers
	 * @Author:Deepti Mhatre
	 * @Created Date: 13 Dec 2022
	 * 
	 */
	
	@Override
	public String greet() {
		return "Hello from Customer Service Layer";
	}
	
	@Override
	public Customer addCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

	
	@Override
	public List<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}

	
	@Override
	public Customer getCustomerById(int id) {
		return customerRepository.findById(id).orElseThrow(()-> new IDNotFoundException(AppConstants.CUSTOMER_ID_NOT_FOUND_MESSAGE));
	}

	
	@Override
	public Customer updateCustomer(int id, Customer customer) {
		Customer cust=customerRepository.findById(id).orElseThrow(()-> new IDNotFoundException(AppConstants.CUSTOMER_ID_NOT_FOUND_MESSAGE));
		cust.setFirstName(customer.getFirstName());
		cust.setLastName(customer.getLastName());
		cust.setPhoneno(customer.getPhoneno());	
		cust.setAllocated_roomNo(customer.getAllocated_roomNo());
		cust.setDeposit(customer.getDeposit());
		cust.setCheckInTime(customer.getCheckInTime());
		cust.setCountry(customer.getCountry());
		
		return customerRepository.save(cust);
	}

	
	@Override
	public String deleteCustomer(int id) {
		Customer cust=customerRepository.findById(id).orElseThrow(()-> new IDNotFoundException(AppConstants.CUSTOMER_ID_NOT_FOUND_MESSAGE));
		customerRepository.delete(cust);
		return AppConstants.CUSTOMER_DELETE_MESSAGE;
	}
	
	

}
