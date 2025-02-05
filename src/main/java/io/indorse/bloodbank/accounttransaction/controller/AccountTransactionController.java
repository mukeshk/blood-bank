package io.indorse.bloodbank.accounttransaction.controller;

import io.indorse.bloodbank.account.service.AccountService;
import io.indorse.bloodbank.accounttransaction.mapper.AccountTransactionMapper;
import io.indorse.bloodbank.accounttransaction.service.AccountTransactionService;
import io.indorse.bloodbank.branch.service.BranchService;
import io.indorse.bloodbank.common.exception.RecordNotFoundException;
import io.indorse.bloodbank.inventory.service.InventoryService;
import io.indorse.bloodbank.model.domain.*;
import io.indorse.bloodbank.model.dto.DonateBloodTransaction;
import io.indorse.bloodbank.model.dto.ReceiptBloodTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.UUID;

@RestController
@RequestMapping("/api/account/transactions")
@ControllerAdvice
public class AccountTransactionController {

    @Autowired
    private AccountTransactionService accountTransactionService;
    @Autowired
    private AccountService accountService;
    @Autowired
    private BranchService branchService;
    @Autowired
    private InventoryService inventoryService;


    /**
     * Create Transaction
     * @param accountTransactionDTO Holds the transaction detail.
     */
    @PostMapping("/recordDonation")
    public void recordDonation(@Valid @RequestBody DonateBloodTransaction accountTransactionDTO){
        BloodBankAccount account = accountService.findByUUID(accountTransactionDTO.getAccountUUID());
        if(account==null){
            throw new RuntimeException("account does not exist.");
        }
        BloodBankBranch branch = branchService.findByUUID(accountTransactionDTO.getBranchUUID());
        if(branch==null){
            throw new RuntimeException("branch does not exist.");
        }

        AccountTransaction accountTransaction = AccountTransactionMapper.mapNewDonationInstance(accountTransactionDTO);
        accountTransaction.setUuid(UUID.randomUUID().toString());
        accountTransaction.setAccount(account);
        accountTransaction.setBranch(branch);
        accountTransactionService.create(accountTransaction);
    }

    /**
     * Update whether donation is safe
     * @param safe Holds the test result state
     * @param uuid Holds the unique identifier for transaction.
     */
    @PostMapping("/test/{uuid}/{safe}")
    public void updateTestResult(@PathVariable("safe") Boolean safe, @PathVariable("uuid") String uuid){
        accountTransactionService.updateSafe(uuid,safe);
    }

    /**
     * Record Receiving transaction
     * @param receiptBloodTransaction Holds the receiving details.
     */
    @PostMapping("/recordReceipt")
    public void recordReceived(@Valid @RequestBody ReceiptBloodTransaction receiptBloodTransaction){
        Inventory inventory =  inventoryService.findByUUID(receiptBloodTransaction.getInventoryUUID());
        if(inventory==null){
            throw new RecordNotFoundException("Inventory record not found. uuid="+ receiptBloodTransaction.getInventoryUUID());
        }
        inventory.setActive(Boolean.FALSE);
        inventoryService.update(inventory);

        BloodBankAccount account = accountService.findByUUID(receiptBloodTransaction.getAccountUUID());
        if(account==null){
            throw new RecordNotFoundException("Account record not found. uuid="+ receiptBloodTransaction.getAccountUUID());
        }

        AccountTransaction t = new AccountTransaction();
        t.setAccount(account);
        t.setBranch(inventory.getBranch());
        t.setBloodGroup(inventory.getBloodGroup());
        t.setTransactionDate(receiptBloodTransaction.getTransactionDate());
        t.setQuantity(inventory.getQuantity());
        t.setType(TransactionType.WITHDRAW);
        accountTransactionService.create(t);
    }
}
