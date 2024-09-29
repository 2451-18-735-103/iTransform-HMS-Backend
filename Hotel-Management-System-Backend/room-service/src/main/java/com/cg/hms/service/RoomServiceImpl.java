package com.cg.hms.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.hms.entity.Room;
import com.cg.hms.exception.RoomNotFoundException;
import com.cg.hms.repository.RoomRepository;
@Service
public class RoomServiceImpl implements RoomService{
	@Autowired
	RoomRepository roomRepository;
	@Override
	public String addRoom(Room room) throws RoomNotFoundException {
	    // Check if the room ID is already present in the database
	    if (roomRepository.existsById(room.getRoomId())) {
	        throw new RoomNotFoundException("Room with the same ID already exists");
	    }
      
	    // Check if the room details are valid
	    if (room.getRoomId().isEmpty() || (!room.getRoomType().equalsIgnoreCase("AC") && !room.getRoomType().equalsIgnoreCase("NON-AC"))) {
	        throw new RoomNotFoundException("Invalid room details");
	    }

	    // Save the room to the repository
	    roomRepository.save(room);
	    
	    return "Room registered successfully";
	}


		
	

	@Override
	public String updateRoom(String id, Room room) throws RoomNotFoundException{
		// TODO Auto-generated method stub
		Optional<Room> custContainer = roomRepository.findById(id);
		if (custContainer.isPresent()) {
			Room old = custContainer.get();
			old.setRoomRent(room.getRoomRent());
			old.setRoomType(room.getRoomType());
			old.setRoomAvailable(room.getRoomAvailable());
			roomRepository.save(old);
			return "Updated Successfully";
		} else {
			throw new RoomNotFoundException("not found");
		}
	}

	@Override
	public String deleteRoom(String id) throws RoomNotFoundException{
		// TODO Auto-generated method stub
		java.util.Optional<Room> custContainer = roomRepository.findById(id);
		if (custContainer.isPresent()) {
			Room cust = custContainer.get();
			roomRepository.delete(cust);
			return "Deleted Successfully";
		} else {
			throw new RoomNotFoundException("room not found");
		}
	}

	@Override
	public Room viewRoom(String id) throws RoomNotFoundException{
		// TODO Auto-generated method stub
		if(id==null) {
			throw new RoomNotFoundException("id not found");
		}
		return roomRepository.findById(id).get();
	}

	@Override
	public List<Room> viewAllRoom() throws RoomNotFoundException{
		// TODO Auto-generated method stub
		//return roomRepository.findAll();
		List<Room> li = roomRepository.findAll();
		if(li.isEmpty()) {
			throw new RoomNotFoundException("nf");
		}
		return li;
	}

//	@Override
//	public List<String> viewAllRoomId() throws RoomNotFoundException{
//		// TODO Auto-generated method stub
//		List<Room> allRooms = roomRepository.findAll();
//		if(allRooms.isEmpty()) {
//			throw new RoomNotFoundException("not found");
//		}
//		else {
//		ArrayList<String> availableRooms = new ArrayList<String>();
//		for(Room room : allRooms) {
//			if(room.getRoomAvailable().equals("true")) {
//				availableRooms.add(room.getRoomId());
//			}
//		}
//		return availableRooms;
//	}}

	

}
