package com.digi.app.sources.dao;

import org.springframework.data.repository.CrudRepository;
import com.digi.app.sources.model.Catalog;
import com.digi.app.sources.model.Items;
import java.util.List;

public interface ItemsRepository extends CrudRepository<Items, Long> {
	List<Items> findByName(String name);

	List<Items> findByCatalog(Catalog catalog);

	List<Items> findByNameContainingIgnoreCase(String name);

	List<Items> findByNameContainingIgnoreCaseAndCatalog(String name, Catalog catalog);
}
