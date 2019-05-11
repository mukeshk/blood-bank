package io.indorse.bloodbank.accounttransaction.controller;

import io.indorse.bloodbank.account.service.AccountService;
import io.indorse.bloodbank.accounttransaction.mapper.AccountTransactionMapper;
import io.indorse.bloodbank.accounttransaction.service.AccountTransactionService;
import io.indorse.bloodbank.branch.service.BranchService;
import io.indorse.bloodbank.model.domain.AccountTransaction;
import io.indorse.bloodbank.model.domain.BloodBankAccount;
import io.indorse.bloodbank.model.domain.BloodBankBranch;
import io.indorse.bloodbank.model.dto.AccountTransactionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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


    /**
     * Create Transaction
     * @param accountTransactionDTO Holds the transaction detail.
     */
    @PostMapping("/create")
    public void create(@Valid @RequestBody AccountTransactionDTO accountTransactionDTO){
        BloodBankAccount account = accountService.findByUUID(accountTransactionDTO.getAccountUUID());
        if(account==null){
            throw new RuntimeException("account does not exist.");
        }
        BloodBankBranch branch = branchService.findByUUID(accountTransactionDTO.getBranchUUID());
        if(branch==null){
            throw new RuntimeException("branch does not exist.");
        }
        //TODO fetch last transaction. --- check duration

        AccountTransaction accountTransaction = AccountTransactionMapper.mapNewInstance(accountTransactionDTO);
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
    public void updateTestResult(Boolean safe,String uuid){
        AccountTransaction transaction = accountTransactionService.findByUUID(uuid);
        transaction.setSafe(safe);
    }

    @PostMapping("/recordReceipt")
    public void recordReceived(){

    }
}
