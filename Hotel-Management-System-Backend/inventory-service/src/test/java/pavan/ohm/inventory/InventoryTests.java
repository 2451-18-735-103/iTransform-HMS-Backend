package pavan.ohm.inventory;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.hms.inventoryservice.entity.Inventory;
import com.cg.hms.inventoryservice.repository.InventoryRepository;
import com.cg.hms.inventoryservice.service.InventoryService;

@SpringBootTest
class InventoryTests {

	@Autowired
	private InventoryService inventoryService;

	@MockBean
	private InventoryRepository inventoryRepository;

	@Test
	@DisplayName("Add Inventory Test")
	public void addInventoryTest() {
		Inventory inventory = new Inventory("4", "Curtains", "for_room", 1586);
		inventoryService.addInventory(inventory);
		verify(inventoryRepository, times(1)).save(inventory);
	}

	@Test
	@DisplayName("Delete Inventory Test")
	public void DeleteInventoryTest() {
		inventoryService.deleteInventory("4");
		assertEquals(0, inventoryService.viewAllInventory().size());
	}

	@Test
	@DisplayName("Update Inventory Test")
	public void updateInventoryTest() {
		Inventory inventory = new Inventory("3", "carpets", "for_floor", 86);
		when(inventoryRepository.save(inventory)).thenReturn(inventory);
		String id = inventory.getInventoryId();
		inventory.setInventoryName("curtains");
		inventoryService.updateInventory(id, inventory);
		Assertions.assertThat(inventory.getInventoryName().equals("curtains"));
	}

	@Test
	@DisplayName("View all Inventory Test")
	public void ViewAllInventoryTest() {
		when(inventoryRepository.findAll()).thenReturn(Stream
				.of(new Inventory("41", "Soap", "for_bathroom", 850), new Inventory("42", "Sampoo", "for_bathroom", 50))
				.collect(Collectors.toList()));
		assertEquals(2, inventoryService.viewAllInventory().size());
	}

}
