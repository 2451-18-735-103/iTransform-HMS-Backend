package com.cg.hms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.hms.entity.Room;
import com.cg.hms.exception.RoomNotFoundException;
import com.cg.hms.service.RoomService;

@RestController
@RequestMapping("/room")
public class RoomController {

	@Autowired
	RoomService roomService;

	@PostMapping("/addroom")
	public String addRoom(@RequestBody Room room) throws RoomNotFoundException{
		return roomService.addRoom(room);
	}

	@PutMapping("/updateroom/{id}")
	public String updateRoom(@PathVariable String id, @RequestBody Room room) throws RoomNotFoundException{
		return roomService.updateRoom(id, room);
	}

	@DeleteMapping("/deleteroom/{id}")
	public String deleteRoom(@PathVariable String id) throws RoomNotFoundException{
		return roomService.deleteRoom(id);
	}

	@GetMapping("/viewroombyid/{id}")
	public Room viewRoom(@PathVariable String id) throws RoomNotFoundException{
		return roomService.viewRoom(id);
	}

	@GetMapping("/viewallrooms")
	public List<Room> viewAllRoom() throws RoomNotFoundException{
		return roomService.viewAllRoom();
	}
	
//	@GetMapping("/viewallroomid")
//	public List<String> viewAllRoomId() throws RoomNotFoundException{
//		return roomService.viewAllRoomId();
//	}

}
