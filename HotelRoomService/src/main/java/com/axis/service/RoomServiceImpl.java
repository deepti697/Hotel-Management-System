package com.axis.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axis.exception.InvalidpriceException;
import com.axis.exception.RoomNotFoundException;
import com.axis.model.Room;
import com.axis.repository.RoomRepository;
import com.axis.roomdto.RoomDto;
import com.axis.utils.AppConstants;

@Service
public class RoomServiceImpl implements RoomService {
	
	@Autowired
	RoomRepository roomRepository;
	
	/*
	 * @Description: This method is used to perform CRUD operation on rooms
	 * @Param: It takes room parameter
	 * @Returns:It returns rooms parameters
	 * @Author: Deepti Mhatre
	 * @Created Date: 12 Dec 2022
	 * 
	 */
	@Override
	public String greet() {
		return "Welcome to Room Service";
	}
	
	//Method to convert RoomDto to Room(Entity)
	private RoomDto convertToDto(Room room) {
		RoomDto roomdto = new ModelMapper().map(room, RoomDto.class);
		return roomdto;
	}
	
	//Method to convert Room(Entity) to  RoomDto 
	private Room convertToEntity(RoomDto roomdto) {
		Room room = new ModelMapper().map(roomdto, Room.class);
		return room;
	}
	
	
	//Method to add new room in hotel
	@Override
	public RoomDto addRoom(RoomDto roomdto) {
		if (roomdto.getRoomPrice()<=0)
			throw new InvalidpriceException(AppConstants.INVALID_PRICE_MESSAGE );
		Room addRoom=roomRepository.save(convertToEntity(roomdto));
		return convertToDto(addRoom);
	}

	//Method to list all room in hotel
	@Override
	public List<RoomDto> getAllRooms() {
		List<RoomDto> roomdtos = new ArrayList<>();
		List<Room> rooms = roomRepository.findAll();
		for (Room room : rooms) {
			roomdtos.add(convertToDto(room));
		}
		return roomdtos;
	}

	//Method to find room in hotel by RoomNo
	@Override
	public RoomDto getRoomByRoomNo(int RoomNo) {
		Room room = roomRepository.findById(RoomNo).orElseThrow(()-> new RoomNotFoundException(AppConstants.ROOM_NOT_FOUND_MESSAGE));
		return convertToDto(room);
	}

	//Method to update room details in hotel
	@Override
	public RoomDto updateRoom(int RoomNo, RoomDto roomDto) {
		Room rm=roomRepository.findById(RoomNo).orElseThrow(()-> new RoomNotFoundException(AppConstants.ROOM_NOT_FOUND_MESSAGE));
		rm.setRoomNo(roomDto.getRoomNo());
		rm.setAvalibility(roomDto.getAvalibility());
		rm.setCleaning_status(roomDto.getCleaning_status());
		rm.setRoomPrice(roomDto.getRoomPrice());	
		rm.setBed(roomDto.getBed());
		
		return convertToDto(rm);
	}
	
	
	//Method to delete room in hotel
	@Override
	public String deleteRoom(int RoomNo) {
		Room rm=roomRepository.findById(RoomNo).orElseThrow(()-> new RoomNotFoundException(AppConstants.ROOM_NOT_FOUND_MESSAGE));
		roomRepository.delete(rm);
		return AppConstants.ROOM_DELETE_MESSAGE;
		
		
	}

	
	

}
