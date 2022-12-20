package com.axis.service;

import java.util.List;

import com.axis.model.Room;

public interface RoomService {
	
	public String greet();
	public Room addRoom(Room room);
	public List<Room> getAllRooms();
	public Room getRoomById(int id);
	public Room updateRoom(int id,Room room);
	public String deleteRoom(int id);

}
