package com.cg.hms.inventoryservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.hms.inventoryservice.entity.Inventory;
import com.cg.hms.inventoryservice.repository.InventoryRepository;

import java.util.List;
import java.util.Optional;

@Service
public class InventoryServiceImpl implements InventoryService {

	@Autowired
	InventoryRepository inventoryRepository;

	@Override
	public Inventory addInventory(Inventory inventory) {
		return inventoryRepository.save(inventory);
	}

	@Override
	public void updateInventory(String id, Inventory inventory) {
		Optional<Inventory> custContainer = inventoryRepository.findById(id);
		if (custContainer.isPresent()) {
			Inventory old = custContainer.get();
			old.setInventoryName(inventory.getInventoryName());
			old.setInventoryStock(inventory.getInventoryStock());
			old.setInventoryType(inventory.getInventoryType());
			inventoryRepository.save(old);
		} else {
		}
	}

	@Override
	public void deleteInventory(String id) {
		java.util.Optional<Inventory> custContainer = inventoryRepository.findById(id);
		if (custContainer.isPresent()) {
			Inventory cust = custContainer.get();
			inventoryRepository.delete(cust);
		} else {
		}
	}

	@Override
	public Inventory viewInventory(String id) {
		return inventoryRepository.findById(id).get();
	}

	@Override
	public List<Inventory> viewAllInventory() {
		return inventoryRepository.findAll();
	}

}
