package org.vending.machine;

import java.util.Map;

public class VendingMachine {

	private VendingMachineStatus status;
	private Map<Integer, RackItem> rackNumberRackItemMap;

	public VendingMachine(Map<Integer, RackItem> rackNumberRackItemMap) {
		this.status = VendingMachineStatus.NoMoneyInsertedState;
		this.rackNumberRackItemMap = rackNumberRackItemMap;
	}

	public void addProduct(Product product) {
		for (Map.Entry<Integer, RackItem> entry : rackNumberRackItemMap.entrySet()) {
			RackItem rackItem = entry.getValue();
			if (rackItem.getProductId().equals(product.getId())) {
				rackItem.addRackItem();
				return;
			}
		}
	}

	public void insertMoney() {
		this.status = VendingMachineStatus.MoneyInsertedState;
	}

	public void removeProduct(Product product) {
		for (Map.Entry<Integer, RackItem> entry : rackNumberRackItemMap.entrySet()) {
			RackItem rackItem = entry.getValue();
			if (rackItem.getProductId().equals(product.getId())) {
				rackItem.removeRackItem();
				return;
			}
		}
	}

	public void removeProductFromRackItem(RackItem rackItem) {
		if (rackItem.getQuantity() <= 0) {
			System.out.println("Can't remove the product");
			return;
		}
		rackItem.setQuantity(rackItem.getQuantity() - 1);
	}

	public Integer calculateAndReturnMoney(Integer amount, Integer rackNumber) {
		RackItem rackItem = rackNumberRackItemMap.get(rackNumber);
		return rackItem.calculateMoney(amount);
	}

	public void dispenseProduct(Integer rackNumber) {
		removeProductFromRackItem(rackNumberRackItemMap.get(rackNumber));
		status = VendingMachineStatus.DispenseState;
	}

	public void selectProduct(Integer rackNumber) {
		RackItem rackItem = rackNumberRackItemMap.get(rackNumber);
		removeProductFromRackItem(rackItem);
	}
}
