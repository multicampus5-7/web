package db;

public class Pos {
	private String name;
	private int price;
	private int stock;
	private String img;

	public Pos() {
	}

	public Pos(String name, int stock, int price, String img) {
		this.name = name;
		this.price = price;
		this.img = img;
		this.stock = stock;
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

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	@Override
	public String toString() {
		return "Pos [name=" + name + ", price=" + price + ", stock=" + stock + ", img=" + img + "]";
	}

}
