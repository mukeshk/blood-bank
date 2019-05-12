package io.indorse.bloodbank.inventory.service;

import io.indorse.bloodbank.model.domain.AccountTransaction;
import io.indorse.bloodbank.model.domain.Inventory;
import io.indorse.bloodbank.model.domain.InventoryType;
import io.indorse.bloodbank.model.dto.InventorySearchDTO;

import java.util.List;

public interface InventoryService {
    /**
     * Save Inventory Record
     * @param transaction Holds the Account transaction instance
     * @param inventoryType Identifies whether whole blood or blood component.
     */
    public void saveInventory(AccountTransaction transaction, InventoryType inventoryType);

    /**
     * Save Process - Inventory record for each component.
     * @param transaction Holds the Account transaction instance.
     */
    public void saveProcessedComponent(AccountTransaction transaction);

    /**
     * Execute search - apply filter criteria
     * @param searchCriteria Holds the search criteria.
     * @return inventory matching the search filter.
     */
    public List<Inventory> searchInventory(InventorySearchDTO searchCriteria);

    /**
     * Find Inventory by UUID
     * @param uuid Uniquely identifies the inventory
     * @return Holds the inventory instance.
     */
    public Inventory findByUUID(String uuid);

    /**
     * Update Inventory record
     * @param inventory Holds the inventory instance.
     */
    public void update(Inventory inventory);
}
