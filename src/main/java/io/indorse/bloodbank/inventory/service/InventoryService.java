package io.indorse.bloodbank.inventory.service;

import io.indorse.bloodbank.model.domain.AccountTransaction;
import io.indorse.bloodbank.model.domain.Inventory;
import io.indorse.bloodbank.model.domain.InventoryType;
import io.indorse.bloodbank.model.dto.InventorySearchDTO;

import java.util.List;

public interface InventoryService {
    public void saveInventory(AccountTransaction transaction, InventoryType inventoryType);
    public void saveProcessedComponent(AccountTransaction transaction);
    public List<Inventory> searchInventory(InventorySearchDTO searchCriteria);

}
