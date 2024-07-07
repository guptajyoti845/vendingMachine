package org.vending.machine;

public class RackItem {

	private Product product;
	private Integer quantity;

	public RackItem(Product product, Integer quantity) {
		this.product = product;
		this.quantity = quantity;
	}

	public void addRackItem() {
		quantity = quantity + 1;
	}

	public String getProductId() {
		return product.getId();
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer calculateMoney(Integer amount) {
		return product.calculateMoney(amount);
	}

	public boolean removeRackItem() {
		if (quantity.equals(0)) {
			System.out.println("Can't remove the product");
			return true;
		}
		quantity = quantity - 1;
		return false;
	}
}
