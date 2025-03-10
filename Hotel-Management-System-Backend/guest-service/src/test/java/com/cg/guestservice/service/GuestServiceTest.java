package com.cg.guestservice.service;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.guestservice.guestentity.Guest;
import com.cg.guestservice.guestexception.GuestNotFoundException;
import com.cg.guestservice.guestrepository.GuestRepository;

@SpringBootTest
public class GuestServiceTest {
	@Autowired
	private GuestService guestServiceImpl;

	@MockBean
	private GuestRepository guestRepository;

	@Test
	public void addTrainModel_test() {
		Guest guest = new Guest("2","Manasa", "9381049498", "Manu2001@gmail.com", "female", "warangal");
		when(guestRepository.save(guest)).thenReturn(guest);
		System.out.println(guestServiceImpl.addGuest(guest) + "*****************************");
		System.out.println(guest + "Error is there ******************************");
		assertEquals(guest, guestServiceImpl.addGuest(guest));
	}

	@Test
	public void addTrainModel_MissingFields() {
		Guest guest = new Guest("","Manasa", "9381049498", "Manu2001@gmail.com", "female", "warangal");

		// Call the service method and expect a TrainNotFoundException
		assertThrows(GuestNotFoundException.class, () -> {
			guestServiceImpl.addGuest(guest);
		});
	}

	@Test
	public void getGuests_DataFound() {
		List<Guest> guest = new ArrayList<>();

//		TrainModel t = new TrainModel("1","Express Train","Nandyal","Banglore",67,67,"10:00 AM");

		guest.add(new Guest("2","Manasa", "9381049498", "Manu2001@gmail.com", "female", "warangal"));
		guest.add(new Guest("3", "Priya", "9381049498", "Priya@gmail.com", "female", "warangal"));

		when(guestRepository.findAll()).thenReturn(guest);
		assertEquals(2, guestServiceImpl. viewAllGuest().size());
	}

	@Test
	public void getTrainByGuestId_DataFound() {
		Guest t = new Guest("2","Manasa", "9381049498", "Manu2001@gmail.com", "female", "warangal");
		when(guestRepository.findById("2")).thenReturn(Optional.of(t));
		Optional<Guest> result = Optional.of(guestServiceImpl.viewGuestById("2"));
		assertEquals(t, result.get());
	}

	@Test
	public void getGuestByGuestId_DataNotFound() {
	    when(guestRepository.findById("NotFound")).thenReturn(Optional.empty());
	    
	    // Call the service method and expect a TrainNotFoundException
	    assertThrows(GuestNotFoundException.class, () -> {
	        guestServiceImpl.viewGuestById("Train NotFound");
	    });
	}

//	@Test
//	public void getTrainsByName_DataFound() {
//		TrainModel train = new TrainModel("1", "Express Train", "Nandyal", "Banglore", 67, 67, "10:00 AM");
//		when(trainRepository.findByTrainName("Express Train")).thenReturn(List.of(train));
//		List<TrainModel> result = trainServiceImpl.getTrainsbyname("Express Train");
//		assertEquals(train, result.get(0));
//	}
//
//	@Test
//	public void getTrainsByName_DataNotFound() {
//		
//	    when(trainRepository.findByTrainName("NotFound")).thenReturn(new ArrayList<>());
//	    
//	    // Call the service method and expect a TrainNotFoundException
//	    assertThrows(TrainNotFoundException.class, () -> {
//	        trainServiceImpl.getTrainsbyname("Train NotFound");
//	    });
//	}
//
//	@Test
//	public void findByLocation_DataFound() {
//		TrainModel train = new TrainModel("1", "Express Train", "Nandyal", "Banglore", 67, 67, "10:00 AM");
//		List<TrainModel> expectedResults = List.of(train);
//		when(trainRepository.findByTrainFromAndTrainTo("Nandyal", "Banglore")).thenReturn(expectedResults);
//		List<TrainModel> result = trainServiceImpl.findByLocation("Nandyal", "Banglore");
//		assertEquals(expectedResults, result);
//	}
//
//	@Test
//	public void findByLocation_DataNotFound() {
//	  
//	    when(trainRepository.findByTrainFromAndTrainTo("aaa", "bbb")).thenReturn(new ArrayList<>());
//
//	    // Call the service method and expect a TrainNotFoundException
//	    assertThrows(TrainNotFoundException.class, () -> {
//	        trainServiceImpl.findByLocation("aaa", "bbb");
//	    });
//	}
	
	@Test
	public void deleteGuest_Exists() {
	    Guest guest = new Guest("7","Naveen", "9381049498", "manu@gmail.com", "female", "warangal");

	    when(guestRepository.findById("7")).thenReturn(Optional.of(guest));
	    String result = guestServiceImpl.deleteGuest("7");
	    assertEquals("Guest is deleted Successfully", result);
	}

	@Test
	public void deleteGuest_NotExists() {
	    // Stub the behavior of trainRepository.findById to return an empty Optional (train doesn't exist)
          when(guestRepository.findById("7")).thenReturn(Optional.empty());

	    // Call the service method and expect a TrainNotFoundException
	    assertThrows(GuestNotFoundException.class, () -> {
	        guestServiceImpl.deleteGuest("7");
	    });
	}
}
