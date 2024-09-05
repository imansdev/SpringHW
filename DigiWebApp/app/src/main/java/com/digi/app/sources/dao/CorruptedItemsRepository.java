package com.digi.app.sources.dao;

import org.springframework.data.repository.CrudRepository;
import com.digi.app.sources.model.CorruptedItems;

public interface CorruptedItemsRepository extends CrudRepository<CorruptedItems, Long> {
}
