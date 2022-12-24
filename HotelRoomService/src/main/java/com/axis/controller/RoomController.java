package com.axis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.axis.model.Room;
import com.axis.roomdto.RoomDto;
import com.axis.service.RoomService;



@RestController
@RequestMapping("/hotel/room")
public class RoomController {
	
	@Autowired
	RoomService roomService;
	
	@GetMapping("/greet")
	public String greet() {
		return roomService.greet();
	}
	
	@PostMapping("/addRoom")
	public ResponseEntity<RoomDto> addRoom(@RequestBody RoomDto roomdto){
		RoomDto roomdto2 = roomService.addRoom(roomdto);
		return new ResponseEntity<RoomDto>(roomdto2, HttpStatus.OK);
	}
	
	@GetMapping("/getAllRooms")
	public ResponseEntity<List<RoomDto>> getAllRooms(){
		List<RoomDto> roomdtos = roomService.getAllRooms();
		return new ResponseEntity<List<RoomDto>>(roomdtos, HttpStatus.OK);
	}
	
	@GetMapping("/getRoom/{RoomNo}")
	public ResponseEntity<RoomDto> getRoomsById(@PathVariable int RoomNo){
		RoomDto roomdtos = roomService.getRoomByRoomNo(RoomNo);
		return new ResponseEntity<RoomDto>(roomdtos, HttpStatus.OK);
	}
	@PutMapping("/updateRoom/{RoomNo}")
	public ResponseEntity<RoomDto> updateRoom(@PathVariable int RoomNo,@RequestBody RoomDto roomDto){
		return new ResponseEntity<RoomDto>(roomService.updateRoom(RoomNo, roomDto),HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteRSoom/{RoomNo}")
	public ResponseEntity<String> deleteRoom(@PathVariable int RoomNo){
		return new ResponseEntity<String>(roomService.deleteRoom(RoomNo),HttpStatus.OK);
	}


}
