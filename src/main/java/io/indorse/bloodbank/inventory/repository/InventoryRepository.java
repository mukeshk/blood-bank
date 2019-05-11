package io.indorse.bloodbank.inventory.repository;

import io.indorse.bloodbank.model.domain.Inventory;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

public interface InventoryRepository extends PagingAndSortingRepository<Inventory,Long>,InventoryRepositoryCustom {
    public Inventory findByUuid(String uuid);

}
