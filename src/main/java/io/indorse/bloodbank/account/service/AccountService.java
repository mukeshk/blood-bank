package io.indorse.bloodbank.account.service;

import io.indorse.bloodbank.model.domain.BloodBankAccount;

public interface AccountService {
    /**
     * Save the Account instance
     * @param account Holds the account entity to persist
     * @return Hold the account primary key
     */
    public Long create(BloodBankAccount account);

    /**
     * Find the Account instance by UUID
     * @param uuid Uniquely identifies the account entity
     * @return Return Blood Bank account entity
     */
    public BloodBankAccount findByUUID(String uuid);

    /**
     * Find all account entities
     * @return Collection of account entities
     */
    public Iterable<BloodBankAccount> findAll();


    /**
     * Find the Account instance by email
     * @param email Holds the email id
     * @return Return Blood Bank account entity matching the email id
     */
    public BloodBankAccount findByEmail(String email);
}
