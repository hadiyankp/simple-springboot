package hadiyan.springboot.simple.springboot.service;

import hadiyan.springboot.simple.springboot.exception.InventoryNotFoundException;
import hadiyan.springboot.simple.springboot.model.Inventory;
import hadiyan.springboot.simple.springboot.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class InventoryServiceImpl implements InventoryService {
    @Autowired
    private InventoryRepository inventoryRepository;

    @Override
    public Page<Inventory> getAllInventory(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return inventoryRepository.findAll(pageable);
    }

    @Override
    public Inventory addInventory(Inventory inventory) {
        return inventoryRepository.save(inventory);
    }

    @Override
    public void deleteInventory(Long id) {
        if (!inventoryRepository.existsById(id)) {
            throw new InventoryNotFoundException("Inventory with ID " + id + " not found");
        }
        inventoryRepository.deleteById(id);
    }
}
