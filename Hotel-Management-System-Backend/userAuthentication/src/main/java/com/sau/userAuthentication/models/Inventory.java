package com.sau.userAuthentication.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="inventory")
public class Inventory {
	
	@Id
	private String inventoryId;
	private String inventoryType;
	private String inventoryName;
	private int inventoryStock;
	
	public Inventory() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Inventory(String inventoryId, String inventoryType, String inventoryName, int inventoryStock) {
		super();
		this.inventoryId = inventoryId;
		this.inventoryType = inventoryType;
		this.inventoryName = inventoryName;
		this.inventoryStock = inventoryStock;
	}

	public String getInventoryId() {
		return inventoryId;
	}

	public void setInventoryId(String inventoryId) {
		this.inventoryId = inventoryId;
	}

	public String getInventoryType() {
		return inventoryType;
	}

	public void setInventoryType(String inventoryType) {
		this.inventoryType = inventoryType;
	}

	public String getInventoryName() {
		return inventoryName;
	}

	public void setInventoryName(String inventoryName) {
		this.inventoryName = inventoryName;
	}

	public int getInventoryStock() {
		return inventoryStock;
	}

	public void setInventoryStock(int inventoryStock) {
		this.inventoryStock = inventoryStock;
	}

	
}
