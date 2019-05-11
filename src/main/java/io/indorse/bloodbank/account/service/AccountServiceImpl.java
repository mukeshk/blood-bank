package io.indorse.bloodbank.account.service;

import io.indorse.bloodbank.account.repository.AccountRepository;
import io.indorse.bloodbank.model.domain.BloodBankAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("accountService")
public class AccountServiceImpl implements AccountService{

    @Autowired
    private AccountRepository accountRepository;

    /**
     * Save the Account instance
     * @param account Holds the account entity to persist
     * @return Hold the account primary key
     */
    public Long create(BloodBankAccount account){
        accountRepository.save(account);
        return account.getId();
    }

    /**
     * Find the Account instance by UUID
     * @param uuid Uniquely identifies the account entity
     * @return Return Blood Bank account entity matching the UUID
     */
    public BloodBankAccount findByUUID(String uuid){
        return accountRepository.findByUuid(uuid);
    }

    /**
     * Find all account entities
     * @return Collection of account entities
     */
    public Iterable<BloodBankAccount> findAll(){
        return  accountRepository.findAll();
    }

    /**
     * Find the Account instance by email
     * @param email Holds the email id
     * @return Return Blood Bank account entity matching the email id
     */
    public BloodBankAccount findByEmail(String email){
        return accountRepository.findByEmail(email);
    }

}
