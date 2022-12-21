package com.axis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axis.exception.IDNotFoundException;
import com.axis.model.Employee;
import com.axis.repository.EmployeeRepository;
import com.axis.utils.AppConstants;



@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	/*
	 * @Description: This method is used  to perform crud operations on employees
	 * @Param: It takes customer parameter
	 * @Returns:It returns employees
	 * @Author:Deepti Mhatre
	 * @Created Date: 16 Dec 2022
	 * 
	 */
	@Override
	public String greet() {
		return "Hello from Employee Service Layer";
	}
	
	@Override
	public Employee addEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	
	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	
	@Override
	public Employee getEmployeeById(int id) {
		return employeeRepository.findById(id).orElseThrow(()-> new IDNotFoundException(AppConstants.EMPLOYEE_ID_NOT_FOUND_MESSAGE));
	}

	
	@Override
	public Employee updateEmployee(int id, Employee employee) {
		Employee emp=employeeRepository.findById(id).orElseThrow(()-> new IDNotFoundException(AppConstants.EMPLOYEE_ID_NOT_FOUND_MESSAGE));
		emp.setName(employee.getName());
		emp.setAge(employee.getAge());
		emp.setGender(employee.getGender());
		emp.setJob(employee.getJob());
		emp.setSalary(employee.getSalary());
		emp.setPhoneno(employee.getPhoneno());	
		
		return employeeRepository.save(emp);
	}

	
	@Override
	public String deleteEmployee(int id) {
		Employee emp=employeeRepository.findById(id).orElseThrow(()-> new IDNotFoundException(AppConstants.EMPLOYEE_ID_NOT_FOUND_MESSAGE));
		employeeRepository.delete(emp);
		return AppConstants.EMPLOYEE_DELETE_MESSAGE;
	}
	
	

}
