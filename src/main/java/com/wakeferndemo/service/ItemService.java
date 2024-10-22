package com.wakeferndemo.service;

import com.wakeferndemo.models.Item;
import com.wakeferndemo.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {
    @Autowired
    private ItemRepository itemRepository;

    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    public Item addItem(Item item) {
        return itemRepository.save(item);
    }

    public void deleteItem(Long itemId) {
        itemRepository.deleteById(itemId);
    }

    public Item updateItem(Long itemId, Item updatedItem) {
        Item item = itemRepository.findById(itemId).orElseThrow(() -> new RuntimeException("Item not found"));
        item.setName(updatedItem.getName());
        item.setCategory(updatedItem.getCategory());
        item.setPrice(updatedItem.getPrice());
        item.setStockQuantity(updatedItem.getStockQuantity());
        item.setLowStockThreshold(updatedItem.getLowStockThreshold());
        return itemRepository.save(item);
    }

    public List<Item> getLowStockItems() {
        return itemRepository.findByStockQuantityLessThan(10);
    }
}
