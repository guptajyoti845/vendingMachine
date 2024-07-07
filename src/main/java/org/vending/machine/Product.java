package org.vending.machine;

public class Product {

	private ProductType type;
	private String id;
	private Integer price;

	public Product(ProductType type, String id, Integer price) {
		this.type = type;
		this.id = id;
		this.price = price;
	}

	public ProductType getType() {
		return type;
	}

	public String getId() {
		return id;
	}

	public Integer calculateMoney(Integer amount) {
		if (price < amount) {
			return amount - price;
		} else if (price > amount) {
			return price - amount;
		}
		return 0;
	}
}
