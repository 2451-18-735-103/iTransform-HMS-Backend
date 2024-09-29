package com.cg.hms.service;
import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.hms.entity.Staff;
import com.cg.hms.exception.StaffNotFoundException;
import com.cg.hms.repository.StaffRepository;
import com.cg.hms.service.StaffServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@SpringBootTest
public class StaffServiceTest {
	 @MockBean
	    private StaffRepository staffRepository;
	 	@Autowired
	    private StaffService staffService;

//	    @BeforeEach
//	    public void setUp() {
//	        staffService = new StaffServiceImpl(staffRepository);
//	    }

	    @Test
	    public void testAddStaff() {
	        Staff staff = new Staff("124","rISHITHA","KODURU","50000","ry@example.com","21");
	       
	       Mockito.when(staffRepository.save(staff)).thenReturn(staff);

	        String result = staffService.addStaff(staff);
	        assertEquals("Success", result);
	    }

	    @Test
	    public void testAddStaffWithEmptyId() {
	        Staff staff = new Staff("","rISHITHA","KODURU","50000","ry@example.com","21");
	        

	        StaffNotFoundException exception = assertThrows(StaffNotFoundException.class, () -> staffService.addStaff(staff));
	        assertEquals("Staff not found", exception.getMessage());
	    }

	    @Test
	    public void testUpdateStaff() {
	    	Staff staff = new Staff("124","rISHITHA","KODURU","50000","ry@example.com","21");
	        Optional<Staff> optionalRoom = Optional.of(staff);

	        Mockito.when(staffRepository.findById("1")).thenReturn(optionalRoom);
	        Mockito.when(staffRepository.save(staff)).thenReturn(staff);

	        String result = staffService.updateStaff("1", staff);
	        assertEquals("Updated Successfully", result);
	   }
	    @Test
	    public void testUpdateStaffNotFound() {
	        Staff staff = new Staff("124","rISHITHA","KODURU","50000","ry@example.com","21");
	        Mockito.when(staffRepository.findById("124")).thenReturn(Optional.empty());

	        StaffNotFoundException exception = assertThrows(StaffNotFoundException.class, () -> staffService.updateStaff("124", staff));
	        assertEquals("Staff not found", exception.getMessage());
	    }
	    @Test
	    public void testDeleteStaff() {
	        String id = "123";
	        Staff staff = new Staff();
	        staff.setStaffId(id);
	        staff.setStaffName("John");

	        when(staffRepository.findById(id)).thenReturn(Optional.of(staff));

	        String result = staffService.deleteStaff(id);
	        assertEquals("Deleted Successfully", result);
	    }

	    @Test
	    public void testDeleteStaffWithNonexistentId() {
	        String id = "123";

	        when(staffRepository.findById(id)).thenReturn(Optional.empty());

	        StaffNotFoundException exception = assertThrows(StaffNotFoundException.class, () -> staffService.deleteStaff(id));
	        assertEquals("Staff not found", exception.getMessage());
	    }

//	    @Test
//	    public void testViewAllStaff() {
//	        List<Staff> staffList = new ArrayList<>();
//	        // Add staff objects to the list
//
//	        when(staffRepository.findAll()).thenReturn(staffList);
//
//	        List<Staff> result = staffService.viewAllStaff();
//	        assertEquals(staffList, result);
//	    }

	    @Test
	    public void testViewAllStaffEmptyList() {
	        List<Staff> staffList = new ArrayList<>();

	        when(staffRepository.findAll()).thenReturn(staffList);

	        StaffNotFoundException exception = assertThrows(StaffNotFoundException.class, () -> staffService.viewAllStaff());
	        assertEquals("No staff found", exception.getMessage());
	    }

//	    @Test
//	    public void testViewStaff() {
//	        String id = "123";
//	        Staff staff = new Staff();
//	        staff.setStaffId(id);
//	        staff.setStaffName("John");
//
//	        when(staffRepository.findById(id)).thenReturn(Optional.of(staff));
//
//	        Staff result = staffService.viewStaff(id);
//	        assertEquals(staff, result);
//	    }
//
//	    @Test
//	    public void testViewStaffWithNonexistentId() {
//	        String id = "123";
//
//	        when(staffRepository.findById(id)).thenReturn(Optional.empty());
//
//	        StaffNotFoundException exception = assertThrows(StaffNotFoundException.class, () -> staffService.viewStaff(id));
//	        assertEquals("ID not found", exception.getMessage());
//	    }
}
