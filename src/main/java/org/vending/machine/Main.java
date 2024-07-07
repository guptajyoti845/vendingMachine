package org.vending.machine;

import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(String[] args) {

		Product productBeverage = new Product(ProductType.BEVERAGE, "beverage", 100);
		Product productChocolate = new Product(ProductType.CHOCOLATE, "chocolate", 200);
		Product productChips = new Product(ProductType.CHIPS, "chips", 300);

		RackItem rackItemBeverage = new RackItem(productBeverage, 15);
		RackItem rackItemChocolate = new RackItem(productChocolate, 10);
		RackItem rackItemChips = new RackItem(productChips, 5);

		Map<Integer, RackItem> rackNumberAndItemMap = new HashMap<>();
		rackNumberAndItemMap.put(1, rackItemBeverage);
		rackNumberAndItemMap.put(2, rackItemChocolate);
		rackNumberAndItemMap.put(3, rackItemChips);

		VendingMachine vendingMachine = new VendingMachine(rackNumberAndItemMap);

		Wallet wallet = new Wallet(600);
		User user = new User(wallet);

		user.insertMoney(1, vendingMachine, 500);
		user.dispenseProduct(vendingMachine, 1);
	}
}
