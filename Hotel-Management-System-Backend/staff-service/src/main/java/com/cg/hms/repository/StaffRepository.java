package com.cg.hms.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cg.hms.entity.Staff;

@Repository
public interface StaffRepository extends MongoRepository<Staff, String> {

}
