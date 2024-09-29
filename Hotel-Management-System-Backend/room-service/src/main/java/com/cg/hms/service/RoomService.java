package com.cg.hms.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.cg.hms.entity.Room;

import com.cg.hms.entity.Room;

public interface RoomService {
	public String addRoom(Room room);

	public String updateRoom(String id, Room room);

	public String deleteRoom(String id);

	public Room viewRoom(String id);

	public List<Room> viewAllRoom();
	
	//public List<String> viewAllRoomId();
}
