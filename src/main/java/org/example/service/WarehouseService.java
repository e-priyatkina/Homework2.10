package org.example.service;

import jakarta.annotation.PostConstruct;
import org.example.model.Item;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class WarehouseService {

    private final Map<Long, Item> warehouse = new HashMap<>();

    public Item getById(long id) {
        return warehouse.get(id);
    }

    @PostConstruct
    public void postConstruct() {
        List<String> items = List.of("Смартфон", "Телевизор", "Ноутбук", "Монитор");
        for (int i = 0; i < items.size(); i++) {
            long id = i + 1;
            Item item = new Item(id, items.get(i));
            warehouse.put(id, item);
        }
    }
}
