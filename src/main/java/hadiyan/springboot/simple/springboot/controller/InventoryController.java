package hadiyan.springboot.simple.springboot.controller;

import hadiyan.springboot.simple.springboot.dto.ApiResponse;
import hadiyan.springboot.simple.springboot.dto.PageMeta;
import hadiyan.springboot.simple.springboot.mapper.InventoryMapper;
import hadiyan.springboot.simple.springboot.model.Inventory;
import hadiyan.springboot.simple.springboot.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @Autowired
    private InventoryMapper inventoryMapper ;

    @GetMapping
    public ApiResponse<List<Inventory>> getAllInventory(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        Page<Inventory> result = inventoryService.getAllInventory(page, size);

        if (result.isEmpty()) {
            return ApiResponse.errorCustom("Data inventory tidak ditemukan",
                    inventoryMapper.toResponseList(result.getContent())
                    ,PageMeta.from(result));
        }

        return ApiResponse.success(
                inventoryMapper.toResponseList(result.getContent()),
                PageMeta.from(result)
        );
    }

    @PostMapping
    public ResponseEntity<Inventory> addInventory(@RequestBody Inventory inventory) {
        Inventory savedInventory = inventoryService.addInventory(inventory);
        return ResponseEntity.ok(savedInventory);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInventory(@PathVariable Long id) {
        inventoryService.deleteInventory(id);
        return ResponseEntity.noContent().build();
    }
}
