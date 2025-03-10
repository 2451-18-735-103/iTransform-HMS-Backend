package com.sau.userAuthentication.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sau.userAuthentication.feignclient.InventoryClient;
import com.sau.userAuthentication.feignclient.RoomClient;
import com.sau.userAuthentication.feignclient.StaffClient;
import com.sau.userAuthentication.models.Inventory;
import com.sau.userAuthentication.models.Room;
import com.sau.userAuthentication.models.Staff;

import javax.validation.Valid;

@RestController
@RequestMapping("/manager")
public class ManagerController {
	
	@Autowired
	RoomClient roomClient;
	
	@Autowired
	StaffClient staffClient;
	
	@Autowired
	InventoryClient inventoryClient;

	@PostMapping("/addroom")
	@PreAuthorize("hasAuthority('ROLE_MANAGER')")
	public String addRoom(@RequestBody Room room) {
		String addRoom = roomClient.addRoom(room);
		return addRoom;
	}
	
	@PutMapping("/updateroom/{id}")
	@PreAuthorize("hasAuthority('ROLE_MANAGER')")
	public String updateRoom(@PathVariable String id, @RequestBody Room room) {
		String updateRoom = roomClient.updateRoom(id, room);
		return updateRoom;
	}
	
	@DeleteMapping("/deleteroom/{id}")
	@PreAuthorize("hasAuthority('ROLE_MANAGER')")
	public String deleteRoom(@PathVariable String id) {
		String deleteRoom = roomClient.deleteRoom(id);
		return deleteRoom;
	}
	
	@GetMapping("/viewroombyid/{id}")
	@PreAuthorize("hasAnyAuthority('ROLE_MANAGER','ROLE_RECEPTIONIST')")
	public Room viewRoom(@PathVariable String id) {
		Room viewRoom = roomClient.viewRoom(id);
		return viewRoom;
	}
	
	@GetMapping("/viewallrooms")
	@PreAuthorize("hasAnyAuthority('ROLE_MANAGER','ROLE_RECEPTIONIST')")
	public List<Room> viewAllRoom(){
		List<Room> viewAllRoom = roomClient.viewAllRoom();
		return viewAllRoom;
	}
	
	@PostMapping("/addstaff")
	@PreAuthorize("hasAuthority('ROLE_MANAGER')")
    public String addStaff(@RequestBody @Valid Staff staff) {
		 String addStaff = staffClient.addStaff(staff);
		 return addStaff;
	}
	
	@PutMapping("/updatestaff/{id}")
	@PreAuthorize("hasAuthority('ROLE_MANAGER')")
    public String updateStaff(@PathVariable String id, @RequestBody Staff staff) {
		String updateStaff = staffClient.updateStaff(id, staff);
		return updateStaff;
	}
	
	 @DeleteMapping("/deletestaff/{id}")
	 @PreAuthorize("hasAuthority('ROLE_MANAGER')")
	    public String deleteStaff(@PathVariable String id) {
		 String deleteStaff = staffClient.deleteStaff(id);
		 return deleteStaff;
	 }
	 
	 @GetMapping("/viewallstaff")
	 @PreAuthorize("hasAnyAuthority('ROLE_MANAGER','ROLE_OWNER')")
	    public List<Staff> viewAllStaff(){
		 List<Staff> viewAllStaff = staffClient.viewAllStaff();
		 return viewAllStaff;
	 }
	
	 @PostMapping("/add")
	 @PreAuthorize("hasAuthority('ROLE_MANAGER')")
		public Inventory addInventory(@RequestBody Inventory inventory) {
		 Inventory addInventory = inventoryClient.addInventory(inventory);
		 return addInventory;
	 }
	 @PutMapping("/update/{id}")
	 @PreAuthorize("hasAnyAuthority('ROLE_MANAGER')")
		public String updateInventory(@PathVariable String id, @RequestBody Inventory inventory) {
		  String updateInventory = inventoryClient.updateInventory(id, inventory);
		  return updateInventory;
	 }
	 
	 @DeleteMapping("/delete/{id}")
	 @PreAuthorize("hasAnyAuthority('ROLE_MANAGER')")
		public String deleteInventory(@PathVariable String id) {
		 String deleteInventory = inventoryClient.deleteInventory(id);
		 return deleteInventory;
	 }
	 
	 @GetMapping("/view/{id}")
	 @PreAuthorize("hasAuthority('ROLE_MANAGER')")
		public Inventory viewInventory(@PathVariable String id) {
		 Inventory viewInventory = inventoryClient.viewInventory(id);
		 return viewInventory;
	 }
	 
	 @GetMapping("/viewall")
	 @PreAuthorize("hasAuthority('ROLE_MANAGER')")
		public List<Inventory> viewAllInventory(){
		 List<Inventory> viewAllInventory = inventoryClient.viewAllInventory();
		 return viewAllInventory;
	 }
	
	
}
