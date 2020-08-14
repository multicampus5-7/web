package com.sds;

public class Menu{
	private String id;
	private String name;
	private int price;
	private int stock;
	public Menu() {
	}
	public Menu(String id, int stock) {
		super();
		this.id = id;
		this.stock = stock;
	}
	public Menu(String id, String name, int price, int stock) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.stock = stock;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	@Override
	public String toString() {
		return "Menu [id=" + id + ", name=" + name + ", price=" + price + ", stock=" + stock + "]";
	}
	
}