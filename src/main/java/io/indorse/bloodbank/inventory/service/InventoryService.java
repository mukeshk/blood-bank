package io.indorse.bloodbank.inventory.service;

import io.indorse.bloodbank.model.domain.AccountTransaction;
import io.indorse.bloodbank.model.domain.InventoryType;

public interface InventoryService {
    public void saveInventory(AccountTransaction transaction, InventoryType inventoryType);
    public void saveProcessedComponent(AccountTransaction transaction);
}
