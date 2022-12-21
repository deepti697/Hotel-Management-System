package com.axis.model;


import jakarta.persistence.Id;
import java.time.LocalDateTime;


public class Customer {
	
	@Id
	private int id;
	private String firstName;
	private String lastName;
	private long phoneno;
	private String allocated_roomNo;
	private double deposit;
	private LocalDateTime checkInTime=LocalDateTime.now();
	private String country;
	
	
	public Customer(int id, String firstName, String lastName, long phoneno, String allocated_roomNo, double deposit,
			LocalDateTime checkInTime, String country) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneno = phoneno;
		this.allocated_roomNo = allocated_roomNo;
		this.deposit = deposit;
		this.checkInTime = checkInTime;
		this.country = country;
	}


	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public long getPhoneno() {
		return phoneno;
	}


	public void setPhoneno(long phoneno) {
		this.phoneno = phoneno;
	}


	public String getAllocated_roomNo() {
		return allocated_roomNo;
	}


	public void setAllocated_roomNo(String allocated_roomNo) {
		this.allocated_roomNo = allocated_roomNo;
	}


	public double getDeposit() {
		return deposit;
	}


	public void setDeposit(double deposit) {
		this.deposit = deposit;
	}


	public LocalDateTime getCheckInTime() {
		return checkInTime;
	}


	public void setCheckInTime(LocalDateTime checkInTime) {
		this.checkInTime = checkInTime;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}
	
	
	
	
	
	
}


