package com.design_pattern.facade.subsystems;

import org.springframework.stereotype.Component;
import java.util.*;

@Component
public class InventoryService {
    private Map<String, Integer> inventory = new HashMap<>();

    public InventoryService() {
        // Inicializar inventario
        inventory.put("LAPTOP-001", 50);
        inventory.put("PHONE-002", 30);
        inventory.put("TABLET-003", 20);
    }

    public boolean checkStock(String productId, int quantity) {
        Integer available = inventory.get(productId);
        return available != null && available >= quantity;
    }

    public void reserveStock(String productId, int quantity) {
        if (checkStock(productId, quantity)) {
            inventory.put(productId, inventory.get(productId) - quantity);
        } else {
            throw new RuntimeException("Stock insuficiente para " + productId);
        }
    }

    public void releaseStock(String productId, int quantity) {
        inventory.put(productId, inventory.getOrDefault(productId, 0) + quantity);
    }

    public int getAvailableStock(String productId) {
        return inventory.getOrDefault(productId, 0);
    }
}
