package io.indorse.bloodbank.account.controller;

import io.indorse.bloodbank.account.mapper.AccountMapper;
import io.indorse.bloodbank.account.service.AccountService;
import io.indorse.bloodbank.common.exception.RecordNotFoundException;
import io.indorse.bloodbank.model.domain.BloodBankAccount;
import io.indorse.bloodbank.model.dto.BloodBankAccountDTO;
import io.indorse.bloodbank.model.dto.BloodBankAccountListDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
     * Register a member account
     * @param accountDTO Holds the account details.
     * @return String UUID uniquely identifies a member.
     */
    @PostMapping("/create")
    public ResponseEntity<String> create(@Valid @RequestBody BloodBankAccountDTO accountDTO){
        if(accountService.findByEmail(accountDTO.getEmail())!=null){
            throw new RuntimeException("Email Id already used.");
        }
        BloodBankAccount account = AccountMapper.mapNewInstance(accountDTO);
        account.setUuid(UUID.randomUUID().toString());
        accountService.create(account);
        return ResponseEntity.ok(account.getUuid());
    }

    /**
     * Fetch the member detail
     * @param uuid Identifies the member account
     * @return Return the account detail
     */
    @GetMapping("/{uuid}")
    public BloodBankAccountDTO findById(@PathVariable("uuid") String uuid){
        BloodBankAccount account = accountService.findByUUID(uuid);
        if(account==null){
            throw new RecordNotFoundException("account record not found for uuid:="+ uuid);

        }
        BloodBankAccountDTO accountDTO = AccountMapper.map(account);
        return accountDTO;
    }

    /**
     * Find all members
     * @return returns the members of blood bank
     */
    @GetMapping("/")
    public List<BloodBankAccountListDTO> findAll(){
        Iterable<BloodBankAccount> accounts = accountService.findAll();
        List<BloodBankAccountListDTO> accountRecords = new ArrayList<>();
        for (BloodBankAccount account:accounts) {
            accountRecords.add(AccountMapper.mapToListDTO(account));
        }
        return accountRecords;
    }
}
