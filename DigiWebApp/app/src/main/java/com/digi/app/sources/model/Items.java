package com.digi.app.sources.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "ALL_ITEMS")
public class Items {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "NAME_ITEM", length = 50, nullable = false, unique = false)
	@NotBlank(message = "Name is empty")
	private String name;

	@Column(name = "CATALOG_ITEM", length = 50, nullable = false, unique = false)
	@Enumerated(EnumType.STRING)
	@NotNull(message = "Catalog is emty")
	private Catalog catalog;

	@Column(name = "PRICE_ITEM", unique = false, nullable = false)
	@Min(value = 0, message = "Price must be a positive number")
	private long price;

	public Items() {}

	public CorruptedItems moveToCorrupted(String reason) {
		CorruptedItems corruptedItem = new CorruptedItems();
		corruptedItem.setItems(this);
		corruptedItem.setReason(reason);
		return corruptedItem;
	}

	public void setCatalog(Catalog catalog) {
		this.catalog = catalog;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public Catalog getCatalog() {
		return catalog;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public long getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return "Items [id=" + id + ", name=" + name + ", catalog=" + catalog + ", price" + price
				+ "]";
	}


}
