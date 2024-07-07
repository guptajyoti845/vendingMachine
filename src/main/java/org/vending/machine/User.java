package org.vending.machine;

public class User {

	private Wallet wallet;

	public User(Wallet wallet) {
		this.wallet = wallet;
	}

	public void selectProduct(VendingMachine vendingMachine, Integer rackNumber) {
		vendingMachine.selectProduct(rackNumber);
	}

	public void dispenseProduct(VendingMachine vendingMachine, Integer rackNumber) {
		vendingMachine.dispenseProduct(rackNumber);
	}

	public void insertMoney(Integer rackNumber, VendingMachine vendingMachine, Integer amount) {
		wallet.deductMoney(amount);
		vendingMachine.insertMoney();
		Integer remainingAmount = vendingMachine.calculateAndReturnMoney(amount, rackNumber);
		if (remainingAmount < 0) {
			System.out.println("Amount is less than the product price");
		}
		wallet.addMoney(remainingAmount);
	}
}
