package io.indorse.bloodbank.accounttransaction.controller;

import io.indorse.bloodbank.account.mapper.AccountMapper;
import io.indorse.bloodbank.account.service.AccountService;
import io.indorse.bloodbank.accounttransaction.mapper.AccountTransactionMapper;
import io.indorse.bloodbank.accounttransaction.service.AccountTransactionService;
import io.indorse.bloodbank.branch.service.BranchService;
import io.indorse.bloodbank.model.domain.AccountTransaction;
import io.indorse.bloodbank.model.domain.BloodBankAccount;
import io.indorse.bloodbank.model.domain.BloodBankBranch;
import io.indorse.bloodbank.model.dto.AccountTransactionDTO;
import io.indorse.bloodbank.model.dto.BloodBankAccountDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/api/account/transactions")
public class AccountTransactionController {

    @Autowired
    private AccountTransactionService accountTransactionService;
    @Autowired
    private AccountService accountService;
    @Autowired
    private BranchService branchService;

    @PostMapping("/create")
    public void create(@Valid @RequestBody AccountTransactionDTO accountTransactionDTO){
        BloodBankAccount account = accountService.findByUUID(accountTransactionDTO.getAccountUUID());
        //if null -- invalid bad request
        BloodBankBranch branch = branchService.findByUUID(accountTransactionDTO.getBranchUUID());
        //if null -- invalid bad request
        AccountTransaction accountTransaction = AccountTransactionMapper.mapNewInstance(accountTransactionDTO);
        accountTransaction.setUuid(UUID.randomUUID().toString());
        accountTransaction.setAccount(account);
        accountTransaction.setBranch(branch);
        accountTransactionService.create(accountTransaction);
    }


}
