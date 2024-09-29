package com.cg.hms.inventoryservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cg.hms.inventoryservice.entity.Inventory;

@Repository
public interface InventoryRepository extends MongoRepository<Inventory, String> {

}
