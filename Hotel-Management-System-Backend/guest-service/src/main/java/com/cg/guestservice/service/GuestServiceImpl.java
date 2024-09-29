package com.cg.guestservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.guestservice.guestentity.Guest;
import com.cg.guestservice.guestexception.GuestNotFoundException;
import com.cg.guestservice.guestrepository.GuestRepository;

@Service
public class GuestServiceImpl implements GuestService{

	@Autowired
	GuestRepository guestRepository;
	
	@Override
	public Guest addGuest(Guest guest) {
		// TODO Auto-generated method stub
		if(guest.getGuestId().isEmpty()||guest.getGuestName().isEmpty()||guest.getGuestGender().isEmpty()||guest.getGuestEmail().isEmpty()||guest.getGuestContact().isEmpty()||guest.getGuestAddress().isEmpty()) {
			throw new GuestNotFoundException("Please fill every field appropriately");
		}
	else {
		return guestRepository.save(guest);}
	}

	@Override
	public Guest updateGuest(String id, Guest guest) throws GuestNotFoundException{
		// TODO Auto-generated method stub
		Optional<Guest> g = guestRepository.findById(id);
  		if (g.isPresent()) {
  			Guest s = g.get();
  			g.get().setGuestAddress(guest.getGuestAddress());
  			g.get().setGuestContact(guest.getGuestContact());
  			g.get().setGuestEmail(guest.getGuestEmail());
  			g.get().setGuestGender(guest.getGuestGender());
  			g.get().setGuestName(guest.getGuestName());
  			Guest updated=guestRepository.save(s);
  			return updated;
  		} else {
  			throw new GuestNotFoundException("Guest not found with ID: " + id);
  		}
	}

	@Override
	public String deleteGuest(String id) throws GuestNotFoundException{
		// TODO Auto-generated method stub
		Optional<Guest> custContainer = guestRepository.findById(id);
  		if (custContainer.isPresent()) {
  			guestRepository.deleteById(id);
  			return "Guest is deleted Successfully";
  		} else {
  			throw new GuestNotFoundException("Guest not found with ID: " + id);
  		}
		
	}

	@Override
	public 	Guest viewGuestById(String guestId) {
		// TODO Auto-generated method stub
		//return guestRepository.findById(guestId).get();
		 return guestRepository.findById(guestId)
	                .orElseThrow(() -> new GuestNotFoundException("Guest not found with ID: " + guestId));
	}

	@Override
	public List<Guest> viewAllGuest() {
		// TODO Auto-generated method stub
		return guestRepository.findAll();
	}

}
