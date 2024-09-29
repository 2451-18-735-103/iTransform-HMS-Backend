package com.cg.hms.inventoryservice.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.cg.hms.inventoryservice.entity.Inventory;
import com.cg.hms.inventoryservice.service.InventoryService;

import java.util.List;

@RestController
@RequestMapping("/inventory")
@CrossOrigin("*")
public class InventoryControl {

	@Autowired
	InventoryService inventoryService;

	@PostMapping("/add")
	public Inventory addInventory(@RequestBody Inventory inventory) {
		return inventoryService.addInventory(inventory);
	}

	@PutMapping("/update/{id}")
	public void updateInventory(@PathVariable String id, @RequestBody Inventory inventory) {
		 inventoryService.updateInventory(id, inventory);
	}

	@DeleteMapping("/delete/{id}")
	public void deleteInventory(@PathVariable String id) {
		 inventoryService.deleteInventory(id);
	}

	@GetMapping("/view/{id}")
	public Inventory viewInventory(@PathVariable String id) {
		return inventoryService.viewInventory(id);
	}

	@GetMapping("/viewall")
	public List<Inventory> viewAllInventory() {
		return inventoryService.viewAllInventory();
	}

}
