package com.cg.guestservice.service;

import java.util.List;
import java.util.Optional;

import com.cg.guestservice.guestentity.Guest;

public interface GuestService {
   public Guest addGuest(Guest guest);
   public Guest updateGuest(String id,Guest guest);
   public String deleteGuest(String id);
   public Guest viewGuestById(String guestId);
   public List<Guest> viewAllGuest();
}
