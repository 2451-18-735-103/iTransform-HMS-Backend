package com.cg.hms.entity;

import org.springframework.data.mongodb.core.mapping.Document;


import jakarta.validation.constraints.NotBlank;

import lombok.Data;

@Data

@Document(collection = "Room")
public class Room {
	@org.springframework.data.annotation.Id
	@NotBlank(message="room id cannot be blank")
	private String roomId;
	private String roomType;
	private String roomRent;
	private String roomAvailable;
	
	public Room() {}
	public Room(String roomId, String roomType, String roomRent, String roomAvailable) {
		super();
		this.roomId = roomId;
		this.roomType = roomType;
		this.roomRent = roomRent;
		this.roomAvailable = roomAvailable;
	}
	public String getRoomId() {
		return roomId;
	}
	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}
	public String getRoomType() {
		return roomType;
	}
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	public String getRoomRent() {
		return roomRent;
	}
	public void setRoomRent(String roomRent) {
		this.roomRent = roomRent;
	}
	public String getRoomAvailable() {
		return roomAvailable;
	}
	public void setRoomAvailable(String roomAvailable) {
		this.roomAvailable = roomAvailable;
	}
	
}
