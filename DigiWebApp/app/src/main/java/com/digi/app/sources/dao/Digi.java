package com.digi.app.sources.dao;

import java.util.Optional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import com.digi.app.sources.model.Catalog;
import com.digi.app.sources.model.CorruptedItems;
import com.digi.app.sources.model.Items;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Component
public class Digi {
	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	ItemsRepository itemsRepository;

	@Autowired
	CorruptedItemsRepository corruptedItemsRepository;

	@Transactional
	public void saveItem(Items item) {
		itemsRepository.save(item);
	}

	@Transactional
	public boolean deleteItemById(long id) {
		if (itemsRepository.existsById(id)) {
			itemsRepository.deleteById(id);
			return true;
		} else
			return false;
	}

	public Optional<Items> searchById(long id) {
		return itemsRepository.findById(id);
	}

	public List<Items> getAllItems() {
		return (List<Items>) itemsRepository.findAll();
	}

	@Transactional
	public Optional<Items> updateItemById(long id, Items newItem) {
		Optional<Items> optionalItem = itemsRepository.findById(id);
		if (optionalItem.isPresent()) {
			Items existingItem = optionalItem.get();
			existingItem.setName(newItem.getName());
			existingItem.setCatalog(newItem.getCatalog());
			existingItem.setPrice(newItem.getPrice());
			itemsRepository.save(existingItem);
			return Optional.of(existingItem);
		} else {
			return Optional.empty();
		}
	}

	public List<Items> getItemsByNameAndCatalog(String name, Catalog catalog) {
		if (name != null && catalog != null) {
			return itemsRepository.findByNameContainingIgnoreCaseAndCatalog(name, catalog);
		} else if (name != null) {
			return itemsRepository.findByNameContainingIgnoreCase(name);
		} else if (catalog != null) {
			return itemsRepository.findByCatalog(catalog);
		} else {
			return getAllItems();
		}
	}

	@Transactional
	public void moveItemToCorrupted(long id, String reason) {
		Optional<Items> selectedItem = itemsRepository.findById(id);
		if (selectedItem.isPresent()) {
			Items item = selectedItem.get();
			CorruptedItems corruptedItem = item.moveToCorrupted(reason);
			corruptedItemsRepository.save(corruptedItem);
		}
	}

	public List<CorruptedItems> getAllCorruptedItems() {
		return (List<CorruptedItems>) corruptedItemsRepository.findAll();
	}

	public Optional<CorruptedItems> getCorruptedItemById(long id) {
		return corruptedItemsRepository.findById(id);
	}

	@Transactional
	public boolean updateCorruptedItemReason(long id, String newReason) {
		Optional<CorruptedItems> selectedItem = corruptedItemsRepository.findById(id);
		if (selectedItem.isPresent()) {
			CorruptedItems corruptedItem = selectedItem.get();
			corruptedItem.setReason(newReason);
			corruptedItemsRepository.save(corruptedItem);
			return true;
		}
		return false;
	}

	@Transactional
	public boolean deleteCorruptedItem(long id) {
		if (corruptedItemsRepository.existsById(id)) {
			corruptedItemsRepository.deleteById(id);
			return true;
		}
		return false;
	}
}
