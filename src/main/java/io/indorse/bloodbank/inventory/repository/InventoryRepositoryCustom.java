package io.indorse.bloodbank.inventory.repository;

import io.indorse.bloodbank.model.domain.Inventory;
import io.indorse.bloodbank.model.dto.InventorySearchDTO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("inventoryRepository")
public interface InventoryRepositoryCustom {
    /**
     * Search by criteria
     * @param searchCriteria Holds the search criteria.
     * @return inventory matching the search criteria.
     */
    public List<Inventory> searchByCriteria(InventorySearchDTO searchCriteria);
}

