package com.cg.hms.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;


import com.cg.hms.entity.Staff;

import com.cg.hms.exception.StaffNotFoundException;

import com.cg.hms.service.StaffService;

@SpringBootTest
public class StaffControllerTest {
	@InjectMocks
    private StaffController staffController;

    @Mock
    private StaffService staffService;
    @Test
    public void testAddStaff()  {

    	 Staff staff = new Staff();
         // Initialize room object with test data

         // Mock the behavior of the roomService
         Mockito.when(staffService.addStaff(staff)).thenReturn("Staff added successfully");

         // Call the controller method
         String response = staffController.addStaff(staff);

         // Verify the response
         assertEquals("Staff added successfully", response);
    }
    @Test
    public void testUpdateStaff() throws StaffNotFoundException {
        String staffId = "1";
        Staff staff = new Staff();
        // Initialize room object with test data

        // Mock the behavior of the roomService
        Mockito.when(staffService.updateStaff(staffId, staff)).thenReturn("Updated Successfully");

        // Call the controller method
        String response = staffController.updateStaff(staffId, staff);

        // Verify the response
        assertEquals("Updated Successfully", response);
    }

    @Test
    public void testDeleteStaff() throws StaffNotFoundException {
        String staffId = "1";

        // Mock the behavior of the roomService
        Mockito.when(staffService.deleteStaff(staffId)).thenReturn("Deleted Successfully");

        // Call the controller method
        String response = staffController.deleteStaff(staffId);

        // Verify the response
        assertEquals("Deleted Successfully", response);
    }

   

    @Test
    public void testViewAllStaff() throws StaffNotFoundException {
        List<Staff> roomList = new ArrayList<>();
        // Initialize roomList with test data

        // Mock the behavior of the roomService
        Mockito.when(staffService.viewAllStaff()).thenReturn(roomList);

        // Call the controller method
        List<Staff> response =staffController.viewAllStaff();

        // Verify the response
        assertNotNull(response);
        // Add assertions to check the contents of the List<Room>
    }

}
