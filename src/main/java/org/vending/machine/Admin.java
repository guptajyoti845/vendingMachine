package org.vending.machine;

public class Admin {
	private void addProduct(VendingMachine vendingMachine, Product product) {
		vendingMachine.addProduct(product);
	}

	private void removeProduct(VendingMachine vendingMachine, Product product) {
		vendingMachine.removeProduct(product);
	}
}
