package io.indorse.bloodbank.inventory.controller;

import io.indorse.bloodbank.accounttransaction.service.AccountTransactionService;
import io.indorse.bloodbank.model.domain.AccountTransaction;
import io.indorse.bloodbank.model.dto.InventoryListDTO;
import io.indorse.bloodbank.model.dto.InventorySearchDTO;
import io.indorse.bloodbank.model.dto.StorageType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class InventoryController {

    @Autowired
    private AccountTransactionService accountTransactionService;

    @PostMapping("/search")
    public ResponseEntity<List<InventoryListDTO>> findInventory(@RequestBody InventorySearchDTO searchDTO){
        List<InventoryListDTO> inventoryList = new ArrayList<>();
        return ResponseEntity.ok(inventoryList);
    }

    @PostMapping("/store/uuid/{storageType}")
    public void storeInventory(String transactionUUID, StorageType storageType){
        AccountTransaction transaction = accountTransactionService.findByUUID(transactionUUID);

        transactionProcessable(transaction);

        if(StorageType.WHOLE_BLOOD.equals(storageType)){

        }else{

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
