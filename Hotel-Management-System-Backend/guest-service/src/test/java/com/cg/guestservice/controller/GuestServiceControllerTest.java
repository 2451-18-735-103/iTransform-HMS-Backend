package com.cg.guestservice.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import com.cg.guestservice.guestcontroller.GuestController;
import com.cg.guestservice.guestentity.Guest;
import com.cg.guestservice.service.GuestService;

@SpringBootTest
public class GuestServiceControllerTest {
	@Autowired
	private GuestController guestcontroller;

	@MockBean
	private GuestService guestservice;
	
	@Test
	public void addGuestModel_test() {
		Guest guest = new Guest("2","Manasa", "9381049498", "Manu2001@gmail.com", "female", "warangal");
		when(guestservice.addGuest(guest)).thenReturn(guest);
		ResponseEntity<Guest> response = guestcontroller.addGuestDetails(guest);
		assertNotNull(response);
		assertEquals(200, response.getStatusCodeValue());
		assertEquals(guest, response.getBody());
	}
	
	@Test
	public void getAllTrains_test() {
		List<Guest> guest = new ArrayList<>();

		guest.add(new Guest("2","Manasa", "9381049498", "Manu2001@gmail.com", "female", "warangal"));
		guest.add(new Guest("3", "Priya", "9381049498", "Priya@gmail.com", "female", "warangal"));

		when(guestservice.viewAllGuest()).thenReturn(guest);
		ResponseEntity<List<Guest>> response = guestcontroller.viewAllGuest();
		List<Guest> guests = response.getBody();
		assertEquals(2, guests.size());
	}
	
	  @Test
	  public void getTrainById_test(){
		Guest t = new Guest("2","Manasa", "9381049498", "Manu2001@gmail.com", "female", "warangal");
		when(guestservice.viewGuestById("2")).thenReturn(t);
		ResponseEntity<Guest> response=guestcontroller.viewGuestById("2");
		Guest guest = response.getBody();
		assertEquals(t, guest);
	}
	  
	 
//	  @Test
//	  public void getTrainByName_test()  {
//	      
//	      List<TrainModel> trainList = new ArrayList<>();
//	      trainList.add(new TrainModel("1", "Intercity", "Warangal", "Hyderabad", 80, 30, "7:45 AM"));
//	        trainList.add(new TrainModel("2", "shatavana", "warangal", "Secundrabad", 105, 90, "12:30 PM"));
//
//	      List<TrainModel> filteredList = new ArrayList<>();
//	      for (TrainModel train : trainList) {
//	          if ("Intercity".equals(train.getTrainName())) {
//	              filteredList.add(train);
//	          }
//	      }
//
//	      when(trainservice.getTrainsbyname("Intercity")).thenReturn(filteredList);
//
//	      ResponseEntity<List<TrainModel>> response = traincontroller.getTrainsbyname("Intercity");
//
//	      assertNotNull(response);
//	      List<TrainModel> trains = response.getBody();
//	      assertEquals(1, trains.size());
//	      assertEquals("Intercity", trains.get(0).getTrainName());
//	  }


	  @Test
	    public void deleteTrain_test() {
	        
	        String guestId = "2";

	        String expectedResponse = "Guest with number " + guestId + " has been deleted successfully";

	        when( guestservice.deleteGuest(guestId)).thenReturn(expectedResponse);

	        ResponseEntity<String> response = guestcontroller.deleteGuest(guestId);

	        assertNotNull(response);

	        assertEquals(expectedResponse, response.getBody());
	    }
	
//	  @Test
//	    public void findByLocation_test() {
//	        
//	        String trainFrom = "Warangal";
//	        String trainTo = "Hyderabad";
//
//	        List<Guest> guestList = new ArrayList<>();
//	        guestList.add(new Guest("7","Naveen", 9381049498L, "manu@gmail.com", "female", "warangal"));
//	        guestList.add(new Guest("8", "Navya", 9381049498L, "manu@gmail.com", "female", "warangal"));
//
//	        List<Guest> filteredList = new ArrayList<>();
//		      for (Guest guest : guestList) {
//		          if (trainFrom.equals(train.getTrainFrom()) && trainTo.equals(train.getTrainTo())) {
//		              filteredList.add(train);
//		          }
//		      }
//	        
//	        when(trainservice.findByLocation(trainFrom, trainTo)).thenReturn(filteredList);
//
//	        ResponseEntity<List<TrainModel>> response = traincontroller.findByLocation(trainFrom, trainTo);
//
//	        assertNotNull(response);
//
//	        assertEquals(200, response.getStatusCodeValue());
//
//	        List<TrainModel> trains = response.getBody();
//	        assertNotNull(trains);
//	        assertEquals(1, trains.size());
//	        
//	    }
//	  
	  @Test
	    public void updateTrain_test() {
	        String guestId = "2";

	        Guest updatedGuest = new Guest(guestId,"Manasa", "9381049498", "Manu2001@gmail.com", "female", "warangal");

	        when(guestservice.updateGuest(guestId, updatedGuest)).thenReturn(updatedGuest);

	        ResponseEntity<Guest> response = guestcontroller.updateGuest(guestId, updatedGuest);

	        assertNotNull(response);

	        assertEquals(200, response.getStatusCodeValue());

	        assertEquals(updatedGuest, response.getBody());
	    }

}
