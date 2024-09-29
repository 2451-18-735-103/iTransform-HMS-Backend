package com.sau.userAuthentication.feignclient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.sau.userAuthentication.models.Room;


@FeignClient(name="RoomService",url = "http://localhost:9382/room")
public interface RoomClient {

	@PostMapping("/addroom")
	public String addRoom(@RequestBody Room room);
	
	@PutMapping("/updateroom/{id}")
	public String updateRoom(@PathVariable String id, @RequestBody Room room);
	
	@DeleteMapping("/deleteroom/{id}")
	public String deleteRoom(@PathVariable String id);
	
	@GetMapping("/viewroombyid/{id}")
	public Room viewRoom(@PathVariable String id);
	
	@GetMapping("/viewallrooms")
	public List<Room> viewAllRoom();
}
