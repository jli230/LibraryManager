package com.cognixia.jump.model;

public class Product {
	private int id;
	private String item;
	private int qty;
	private String description;
	public Product(int id, String item, int qty, String description) {
		this.id = id;
		this.item = item;
		this.qty = qty;
		this.description = description;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
