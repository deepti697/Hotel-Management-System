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
import com.axis.service.RoomService;



@RestController
@RequestMapping("/ms3")
public class RoomController {
	
	@Autowired
	RoomService roomService;
	
	@GetMapping("/greet")
	public String greet() {
		return roomService.greet();
	}
	
	@PostMapping("/addRoom")
	public ResponseEntity<Room> addRoom(@RequestBody Room room){
		Room room2 = roomService.addRoom(room);
		return new ResponseEntity<Room>(room, HttpStatus.OK);
	}
	
	@GetMapping("/getAllRooms")
	public ResponseEntity<List<Room>> getAllRooms(){
		List<Room> rooms = roomService.getAllRooms();
		return new ResponseEntity<List<Room>>(rooms, HttpStatus.OK);
	}
	
	@GetMapping("/getRoom/{id}")
	public ResponseEntity<Room> getRoomsById(@PathVariable int id){
		Room rooms = roomService.getRoomById(id);
		return new ResponseEntity<Room>(rooms, HttpStatus.OK);
	}
	@PutMapping("/updateRoom/{id}")
	public ResponseEntity<Room> updateRoom(@PathVariable int id,@RequestBody Room room){
		return new ResponseEntity<Room>(roomService.updateRoom(id, room),HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteRSoom/{id}")
	public ResponseEntity<String> deleteRoom(@PathVariable int id){
		return new ResponseEntity<String>(roomService.deleteRoom(id),HttpStatus.OK);
	}


}
