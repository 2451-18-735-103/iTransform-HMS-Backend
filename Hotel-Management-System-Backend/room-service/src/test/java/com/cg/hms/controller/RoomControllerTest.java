package com.cg.hms.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import com.cg.hms.entity.Room;
import com.cg.hms.service.RoomService;

@SpringBootTest
public class RoomControllerTest {
	@Autowired
	private RoomController roomController;
	@MockBean
	private RoomService roomService;
	
	@Test
	public void addRoom_test() {
//		Room room = new Room("1", "NON-AC", "2500", "true");
//		when(roomService.addRoom(room)).thenReturn(room);
//		ResponseEntity<Room> response = roomController.addRoom(room);
//		assertNotNull(response);
//		assertEquals(200, response.getStatusCodeValue());
//		assertEquals(room, response.getBody());
	}
}
