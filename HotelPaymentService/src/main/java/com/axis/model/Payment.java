package com.axis.model;

import java.time.LocalDateTime;
import org.springframework.data.annotation.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;


@Entity
@Table(name="Checkout Details")
public class Payment {
	
	@Id
	private String customerName;
	private LocalDateTime customerInTime;
	private LocalDateTime checkOutTime;
	private double balance;
	private int roomNo;
	
	
	public Payment(String customerName, LocalDateTime customerInTime, LocalDateTime checkOutTime, double balance,
			int roomNo) {
		super();
		this.customerName = customerName;
		this.customerInTime = customerInTime;
		this.checkOutTime = checkOutTime;
		this.balance = balance;
		this.setRoomNo(roomNo);
	}
	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public LocalDateTime getCustomerInTime() {
		return customerInTime;
	}
	public void setCustomerInTime(LocalDateTime customerInTime) {
		this.customerInTime = customerInTime;
	}
	public LocalDateTime getCheckOutTime() {
		return checkOutTime;
	}
	public void setCheckOutTime(LocalDateTime checkOutTime) {
		this.checkOutTime = checkOutTime;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public int getRoomNo() {
		return roomNo;
	}
	public void setRoomNo(int roomNo) {
		this.roomNo = roomNo;
	}
	
	
	
	
	
	
	

}
