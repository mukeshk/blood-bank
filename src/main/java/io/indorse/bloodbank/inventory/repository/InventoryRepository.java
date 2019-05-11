package io.indorse.bloodbank.inventory.repository;

import io.indorse.bloodbank.model.domain.BloodBankBranch;
import io.indorse.bloodbank.model.domain.Inventory;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository("inventoryRepository")
public interface InventoryRepository extends PagingAndSortingRepository<Inventory,Long> {
    public Inventory findByUuid(String uuid);
}
