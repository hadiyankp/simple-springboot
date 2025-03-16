package hadiyan.springboot.simple.springboot.repository;

import hadiyan.springboot.simple.springboot.model.Inventory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory,Long> {
    Page<Inventory> findAll(Pageable pageable);
}
