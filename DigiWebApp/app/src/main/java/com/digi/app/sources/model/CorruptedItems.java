package com.digi.app.sources.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ALL_CORRUPTEDITEMS")
public class CorruptedItems {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@OneToOne
	@JoinColumn(name = "ITEM_ID", unique = true)
	private Items item;

	private String reason;

	public CorruptedItems() {}

	public void setItems(Items item) {
		this.item = item;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public long getId() {
		return id;
	}

	public Items getItem() {
		return item;
	}

	public String getReason() {
		return reason;
	}

	@Override
	public String toString() {

		return "CorruptedItems [id=" + id + ", itemID=" + item + ", reason=" + reason + "]";
	}
}
