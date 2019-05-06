package io.indorse.bloodbank.account.controller;

import io.indorse.bloodbank.account.mapper.AccountMapper;
import io.indorse.bloodbank.account.service.AccountService;
import io.indorse.bloodbank.model.domain.BloodBankAccount;
import io.indorse.bloodbank.model.dto.BloodBankAccountDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    /**
     * Register a blood bank member account
     * @param accountDTO Holds the account details.
     * @return String UUID uniquely identifies a member.
     */
    @PostMapping("/create")
    public ResponseEntity<String> create(@Valid @RequestBody BloodBankAccountDTO accountDTO){
        BloodBankAccount account = AccountMapper.mapNewInstance(accountDTO);
        account.setUuid(UUID.randomUUID().toString());
        accountService.create(account);
        return ResponseEntity.ok(account.getUuid());
    }

    @GetMapping("/{uuid}")
    public BloodBankAccountDTO findById(String uuid){
        BloodBankAccount account = accountService.findByUUID(uuid);
        if(account==null){
            //404
        }
        BloodBankAccountDTO accountDTO = AccountMapper.map(account);
        return accountDTO;
    }

    @GetMapping("/")
    public List<BloodBankAccountDTO> findAll(){
        Iterable<BloodBankAccount> accounts = accountService.findAll();
        List<BloodBankAccountDTO> accountRecords = new ArrayList<>();
        for (BloodBankAccount account:accounts) {
            accountRecords.add(AccountMapper.map(account));
        }
        return accountRecords;
    }
}
