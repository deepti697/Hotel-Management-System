package com.axis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axis.exception.IDNotFoundException;
import com.axis.exception.InvalidpriceException;
import com.axis.model.Room;
import com.axis.repository.RoomRepository;
import com.axis.utils.AppConstants;

@Service
public class RoomServiceImpl implements RoomService {
	
	@Autowired
	RoomRepository roomRepository;
	
	/*
	 * @Description: This method is used to perform CRUD operation on rooms
	 * @Param: It takes room parameter
	 * @Returns:It returns rooms
	 * @Author:Deepti Mhatre
	 * @Created Date: 9 Dec 2022
	 * 
	 */
	@Override
	public String greet() {
		return "Hello from Room Service Layer";
	}
	
	@Override
	public Room addRoom(Room room) {
		if (room.getRoomPrice()<=0)
			throw new InvalidpriceException(AppConstants.INVALID_PRICE_MESSAGE );
		return roomRepository.save(room);
	}

	
	@Override
	public List<Room> getAllRooms() {
		return roomRepository.findAll();
	}

	
	@Override
	public Room getRoomById(int id) {
		return roomRepository.findById(id).orElseThrow(()-> new IDNotFoundException(AppConstants.ROOM_ID_NOT_FOUND_MESSAGE));
	}

	
	@Override
	public Room updateRoom(int id, Room room) {
		Room rm=roomRepository.findById(id).orElseThrow(()-> new IDNotFoundException(AppConstants.ROOM_ID_NOT_FOUND_MESSAGE));
		rm.setRoomNo(room.getRoomNo());
		rm.setAvalibility(room.getAvalibility());
		rm.setCleaning_status(room.getCleaning_status());
		rm.setRoomPrice(room.getRoomPrice());	
		rm.setBed(room.getBed());
		
		return roomRepository.save(rm);
	}

	
	@Override
	public String deleteRoom(int id) {
		Room rm=roomRepository.findById(id).orElseThrow(()-> new IDNotFoundException(AppConstants.ROOM_ID_NOT_FOUND_MESSAGE));
		roomRepository.delete(rm);
		return AppConstants.ROOM_DELETE_MESSAGE;
	}
	

}
