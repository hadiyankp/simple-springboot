package hadiyan.springboot.simple.springboot.mapper;

import hadiyan.springboot.simple.springboot.model.Inventory;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class InventoryMapper {

    public List<Inventory> toResponseList(List<Inventory> list) {
        return list.stream()
                .map(i -> new Inventory(
                        i.getId(),
                        i.getItemName(),
                        i.getQuantity(),
                        i.getType()
                ))
                .collect(Collectors.toList());
    }
}

