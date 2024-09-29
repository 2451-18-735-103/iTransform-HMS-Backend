package com.cg.guestservice.repository;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.guestservice.guestentity.Guest;
import com.cg.guestservice.guestrepository.GuestRepository;
import static org.junit.jupiter.api.Assertions.assertEquals;
@SpringBootTest
public class GuestRepositoryTest {
	@Mock
    private GuestRepository guestRepository;

    @Test
    public void testFindAll() {
        // Mock data
        Guest guest1 = new Guest("2","Manasa", "9381049498", "Manu2001@gmail.com", "female", "warangal");
        Guest guest2 = new Guest("3", "Priya", "9381049498", "Priya@gmail.com", "female", "warangal");
        List<Guest> guests = new ArrayList<>();
        guests.add(guest1);
        guests.add(guest2);
       
        when(guestRepository.findAll()).thenReturn(guests);

        List<Guest> result = guestRepository.findAll();
        assertEquals(2, result.size());
    }

    @Test
    public void testFindById() {
        Guest guest = new Guest("2","Manasa", "9381049498", "Manu2001@gmail.com", "female", "warangal");

        when(guestRepository.findById("2")).thenReturn(Optional.of(guest));

        Optional<Guest> result = guestRepository.findById("2");

        assertEquals(true, result.isPresent());
        assertEquals("Manasa", result.get().getGuestName());
    }

//    @Test
//    public void testFindByTrainName() {
//       
//        TrainModel train1 = new TrainModel("12345", "SuperFastExpress", "tirupathi", "Sec-jun", 450, 50, "7:45 AM");
//        TrainModel train2 = new TrainModel("67890", "CharminarExpress", "Nampally", "kazipet", 150, 40, "3:30 PM");
//        List<TrainModel> trains = new ArrayList<>();
//        trains.add(train1);
//        trains.add(train2);
//
//        when(trainRepository.findByTrainName("CharminarExpress")).thenReturn(trains);
//
//        List<TrainModel> result = trainRepository.findByTrainName("CharminarExpress");
//
//        // Verify the result
//        assertEquals(2,result.size());
//        assertEquals("CharminarExpress", result.get(1).getTrainName());
//    }
//    
//    @Test
//    public void testFindByTrainFromAndTrainTo() {
//        // Mock data
//        TrainModel train1 = new TrainModel("12345", "Train 1", "City A", "City B", 100, 50, "10:00 AM");
//        TrainModel train2 = new TrainModel("67890", "Train 2", "City B", "City C", 150, 40, "12:00 PM");
//       
//        List<TrainModel> trains = new ArrayList<>();
//        trains.add(train1);
//        trains.add(train2);
//
//        when(trainRepository.findByTrainFromAndTrainTo("City A", "City B")).thenReturn(trains);
//
//        List<TrainModel> result = trainRepository.findByTrainFromAndTrainTo("City A", "City B");
//
//        assertEquals(2, result.size());
//        assertEquals("City A", result.get(0).getTrainFrom());
//        assertEquals("City B", result.get(0).getTrainTo());
//    }

}
