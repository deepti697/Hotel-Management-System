package com.axis.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axis.customerdto.CustomerDto;
import com.axis.exception.IDNotFoundException;
import com.axis.model.Customer;
import com.axis.repository.CustomerRepository;
import com.axis.utils.AppConstants;


@Service
public class CustomerServiceImpl implements CustomerService{
	
	
	@Autowired
	CustomerRepository customerRepository;
	
	/*
	 * @Description: This method is used  perform CRUD opeations on customers
	 * @Param: It takes customer parameter
	 * @Returns:It returns customers
	 * @Author:Deepti Mhatre
	 * @Created Date: 10 Dec 2022
	 * 
	 */
	
	@Override
	public String greet() {
		return "Welcome to Customer Service";
	}
	
	//Method to convert CustomerDto to Customer(Entity)
		private CustomerDto convertToDto(Customer customer) {
			CustomerDto customerdto = new ModelMapper().map(customer, CustomerDto.class);
			return customerdto;
		}
	
	//Method to convert Customer(Entity) to CustomerDto 
		private Customer convertToEntity(CustomerDto customerdto) {
			Customer customer = new ModelMapper().map(customerdto, Customer.class);
			return customer;
		}
		
	
	//Method to register new customer in hotel
	@Override
	public CustomerDto addCustomer(CustomerDto customerdto) {
		Customer customer=customerRepository.save(convertToEntity(customerdto));
		return convertToDto(customer);	
	}

	//Method to list all customer present in hotel
	@Override
	public List<CustomerDto> getAllCustomers() {
		List<CustomerDto> customerdtos = new ArrayList<>();
		List<Customer> customers = customerRepository.findAll();
		for (Customer customer : customers) {
			customerdtos.add(convertToDto(customer));
		}
		return customerdtos;
	}

	//Method to find customer details in hotel by customerID
	@Override
	public CustomerDto getCustomerById(int id) {
		Customer customer =customerRepository.findById(id).orElseThrow(()-> new IDNotFoundException(AppConstants.CUSTOMER_ID_NOT_FOUND_MESSAGE));
		return convertToDto(customer);
	}

	//Method to update customer details in hotel by customerID
	@Override
	public CustomerDto updateCustomer(int id, CustomerDto customerdto) {
		Customer cust=customerRepository.findById(id).orElseThrow(()-> new IDNotFoundException(AppConstants.CUSTOMER_ID_NOT_FOUND_MESSAGE));
		cust.setFirstName(customerdto.getFirstName());
		cust.setLastName(customerdto.getLastName());
		cust.setPhoneno(customerdto.getPhoneno());	
		cust.setAllocated_roomNo(customerdto.getAllocated_roomNo());
		cust.setDeposit(customerdto.getDeposit());
		cust.setCheckInTime(customerdto.getCheckInTime());
		cust.setCountry(customerdto.getCountry());
		
		return convertToDto(cust);
	}

	//Method to delete customer details after checkout
	@Override
	public String deleteCustomer(int id) {
		Customer cust=customerRepository.findById(id).orElseThrow(()-> new IDNotFoundException(AppConstants.CUSTOMER_ID_NOT_FOUND_MESSAGE));
		customerRepository.delete(cust);
		return AppConstants.CUSTOMER_DELETE_MESSAGE;
	}
	
	

}
