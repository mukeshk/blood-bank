package io.indorse.bloodbank.account.service;

import io.indorse.bloodbank.account.repository.AccountRepository;
import io.indorse.bloodbank.model.domain.BloodBankAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("accountService")
public class AccountServiceImpl implements AccountService{

    @Autowired
    private AccountRepository accountRepository;

    public Long create(BloodBankAccount account){
        accountRepository.save(account);
        return account.getId();
    }

    public BloodBankAccount findByUUID(String uuid){
        return accountRepository.findByUuid(uuid);
    }

    public Iterable<BloodBankAccount> findAll(){
        return  accountRepository.findAll();
    }
}
