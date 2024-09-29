package com.cg.hms.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cg.hms.entity.Room;
@Repository
public interface RoomRepository extends MongoRepository<Room, String>{

}
