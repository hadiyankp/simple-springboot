package hadiyan.springboot.simple.springboot.service;

import hadiyan.springboot.simple.springboot.model.Inventory;
import org.springframework.data.domain.Page;

public interface InventoryService {
    Page<Inventory> getAllInventory(int page, int size);
    Inventory addInventory(Inventory inventory);
    void deleteInventory(Long id);
}
