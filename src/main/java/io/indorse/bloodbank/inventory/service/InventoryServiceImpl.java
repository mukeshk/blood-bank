package io.indorse.bloodbank.inventory.service;

import com.sun.org.apache.xpath.internal.operations.Bool;
import io.indorse.bloodbank.inventory.repository.InventoryRepository;
import io.indorse.bloodbank.model.domain.AccountTransaction;
import io.indorse.bloodbank.model.domain.Inventory;
import io.indorse.bloodbank.model.domain.InventoryType;
import io.indorse.bloodbank.model.dto.InventoryListDTO;
import io.indorse.bloodbank.model.dto.InventorySearchDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service("inventoryService")
public class InventoryServiceImpl implements InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;

    @Override
    public void saveInventory(AccountTransaction transaction,InventoryType inventoryType) {
        Inventory inventory = new Inventory();
        inventory.setUuid(UUID.randomUUID().toString());
        inventory.setAccountTransaction(transaction);
        inventory.setBloodGroup(transaction.getBloodGroup());
        inventory.setBranch(transaction.getBranch());
        inventory.setQuantity(transaction.getQuantity()*inventoryType.getPercentageOfWholeBlood());
        inventory.setActive(Boolean.TRUE);
        inventory.setInventoryType(inventoryType);
        LocalDateTime expiryLDT = LocalDateTime.now().plusDays(inventory.getInventoryType().getShelfLifeInDays());
        Date expiryDate = Date.from(expiryLDT.atZone(ZoneId.systemDefault()).toInstant());
        inventory.setExpiryDate(expiryDate);
        inventoryRepository.save(inventory);
    }

    @Override
    public void saveProcessedComponent(AccountTransaction transaction) {
        InventoryType[] processedComponents = InventoryType.getProcessComponents();
        for (InventoryType inventoryType:processedComponents) {
            saveInventory(transaction,inventoryType);
        }
    }

    @Override
    public List<Inventory> searchInventory(InventorySearchDTO searchCriteria){
        return inventoryRepository.searchByCriteria(searchCriteria);
    }

    @Override
    public void update(Inventory inventory) {
        inventoryRepository.save(inventory);
    }

    @Override
    public Inventory findByUUID(String uuid) {
        return inventoryRepository.findByUuid(uuid);
    }
}
