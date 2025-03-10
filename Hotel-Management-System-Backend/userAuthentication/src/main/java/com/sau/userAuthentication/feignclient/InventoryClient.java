package com.sau.userAuthentication.feignclient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.sau.userAuthentication.models.Inventory;



@FeignClient(name = "inventory",url = "http://localhost:8081/inventory")
public interface InventoryClient {

	@PostMapping("/add")
	public Inventory addInventory(@RequestBody Inventory inventory) ;
	
	@PutMapping("/update/{id}")
	public String updateInventory(@PathVariable String id, @RequestBody Inventory inventory);
	
	
	@DeleteMapping("/delete/{id}")
	public String deleteInventory(@PathVariable String id);
	
	@GetMapping("/view/{id}")
	public Inventory viewInventory(@PathVariable String id);
	
	
	@GetMapping("/viewall")
	public List<Inventory> viewAllInventory();
	
}
