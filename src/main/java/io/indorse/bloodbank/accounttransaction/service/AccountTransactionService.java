package io.indorse.bloodbank.accounttransaction.service;

import io.indorse.bloodbank.model.domain.AccountTransaction;

public interface AccountTransactionService {
    /**
     * Create Account Transaction
     * @param accountTransaction Hold the transaction instance
     * @return Primary key - uniquely identifies the record.
     */
    public Long create(AccountTransaction accountTransaction);

    /**
     * Find the Account Transaction by UUID
     * @param uuid Uniquely identifies the record
     * @return Returns the account transaction.
     */
    public AccountTransaction findByUUID(String uuid);

    /**
     * Loads all the account transactions
     * @return List of transactions
     */
    public Iterable<AccountTransaction> findAll();

    /**
     * Update Test result
     * @param uuid transaction record to update.
     * @param safe test result
     */
    public void updateSafe(String uuid,Boolean safe);

    /**
     * Update Processed status of inventory
     * @param uuid Identifies the transaction
     * @param processed updates the processed flag.
     */
    public void updateProcessed(String uuid,Boolean processed);

}
