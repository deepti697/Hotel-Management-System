package com.axis.roomdto;

import jakarta.persistence.Id;

public class RoomDto {
	
	@Id
	private int roomNo;
	private String avalibility;
	private String cleaning_status;
	private double roomPrice;
	private String bed;
	
	public RoomDto(int roomNo, String avalibility, String cleaning_status, double roomPrice, String bed) {
		super();
		this.roomNo = roomNo;
		this.avalibility = avalibility;
		this.cleaning_status = cleaning_status;
		this.roomPrice = roomPrice;
		this.bed = bed;
	}

	public RoomDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(int roomNo) {
		this.roomNo = roomNo;
	}

	public String getAvalibility() {
		return avalibility;
	}

	public void setAvalibility(String avalibility) {
		this.avalibility = avalibility;
	}

	public String getCleaning_status() {
		return cleaning_status;
	}

	public void setCleaning_status(String cleaning_status) {
		this.cleaning_status = cleaning_status;
	}

	public double getRoomPrice() {
		return roomPrice;
	}

	public void setRoomPrice(double roomPrice) {
		this.roomPrice = roomPrice;
	}

	public String getBed() {
		return bed;
	}

	public void setBed(String bed) {
		this.bed = bed;
	}
	
	
	
	

}
