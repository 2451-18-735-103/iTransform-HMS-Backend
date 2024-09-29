package com.cg.guestservice.guestrepository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cg.guestservice.guestentity.Guest;
@Repository
public interface GuestRepository extends MongoRepository<Guest, String>{
  
}
