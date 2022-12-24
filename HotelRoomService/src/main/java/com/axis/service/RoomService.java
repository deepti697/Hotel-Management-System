package com.axis.service;

import java.util.List;
import com.axis.roomdto.RoomDto;

public interface RoomService {
	
	public String greet();
	public RoomDto addRoom(RoomDto roomdto);
	public List<RoomDto> getAllRooms();
	public RoomDto getRoomByRoomNo(int RoomNo);
	public RoomDto updateRoom(int RoomNo,RoomDto roomdto);
	public String deleteRoom(int RoomNo);

}
