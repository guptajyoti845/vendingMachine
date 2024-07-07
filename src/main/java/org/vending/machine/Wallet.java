package org.vending.machine;

public class Wallet {

	private Integer money;

	public Wallet(Integer money) {
		this.money = money;
	}

	public void addMoney(Integer remainingAmount) {
		this.money = money + remainingAmount;
	}

	public void deductMoney(Integer amount) {
		if (money < amount) {
			System.out.println("Wallet doesn't have enough money");
			return;
		}
		this.money = money - amount;
	}
}
