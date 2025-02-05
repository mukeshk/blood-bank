package io.indorse.bloodbank.inventory.controller;

import io.indorse.bloodbank.accounttransaction.service.AccountTransactionService;
import io.indorse.bloodbank.inventory.mapper.InventoryMapper;
import io.indorse.bloodbank.inventory.service.InventoryService;
import io.indorse.bloodbank.model.domain.AccountTransaction;
import io.indorse.bloodbank.model.domain.Inventory;
import io.indorse.bloodbank.model.domain.InventoryType;
import io.indorse.bloodbank.model.dto.InventoryListDTO;
import io.indorse.bloodbank.model.dto.InventorySearchDTO;
import io.indorse.bloodbank.model.dto.StorageType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;

@RestController("/api/inventory")
public class InventoryController {

    @Autowired
    private AccountTransactionService accountTransactionService;

    @Autowired
    private InventoryService inventoryService;

    /**
     * Search Inventory - Find inventory by zipcode,bloodgroup,inventory type
     * @param searchDTO Holds the search criteria.
     * @return Search result matching the criteria.
     */
    @PostMapping("/search")
    public ResponseEntity<List<InventoryListDTO>> findInventory(@RequestBody InventorySearchDTO searchDTO){
        List<InventoryListDTO> inventoryList = new ArrayList<>();
        List<Inventory> inventories= inventoryService.searchInventory(searchDTO);
        for (Inventory i:inventories) {
            inventoryList.add(InventoryMapper.mapToListDTO(i));
        }
        return ResponseEntity.ok(inventoryList);
    }

    /**
     * Store the donate blood as a whole or processed component
     * @param transactionUUID Holds the blood donation transaction which needs to be transform
     *                        to inventory
     * @param storageType Identifies the storage decision.
     */
    @PostMapping("/store/{uuid}/{storageType}")
    public void storeInventory(@PathVariable("uuid") String transactionUUID, @PathVariable("storageType") StorageType storageType){
        AccountTransaction transaction = accountTransactionService.findByUUID(transactionUUID);
        transactionProcessable(transaction);
        accountTransactionService.updateProcessed(transactionUUID,Boolean.TRUE);

        if(StorageType.WHOLE_BLOOD.equals(storageType)){
            inventoryService.saveInventory(transaction, InventoryType.WHOLE);
        }else{
            inventoryService.saveProcessedComponent(transaction);
        }

    }

    /**
     * Validates the business rules for processing the blood donation.
     * @param transaction Holds the Transaction
     */
    private void transactionProcessable(AccountTransaction transaction){
        if(transaction==null){
            throw new RuntimeException("Blood Donation Transaction not found");
        }
        if(Boolean.FALSE.equals(transaction.getSafe() || transaction.getSafe()==null)){
            throw new RuntimeException("Blood Donation Transaction not tested or cannot be used.");
        }
        if(Boolean.TRUE.equals(transaction.getProcessed())){
            throw new RuntimeException("Blood Donation Transaction already processed.");
        }
    }

}
